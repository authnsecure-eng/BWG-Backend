-- PCMC BWG V5 migration: create app_users and related tables to avoid collision with legacy 'users' table

-- 1. Ensure agencies exists
CREATE TABLE IF NOT EXISTS agencies (
    id                    BIGSERIAL PRIMARY KEY,
    agency_name           VARCHAR(150)  NOT NULL,
    agency_code           VARCHAR(50)   NOT NULL,
    contact_person_name   VARCHAR(150)  NOT NULL,
    mobile_no             VARCHAR(15)   NOT NULL,
    email                 VARCHAR(150)  NOT NULL,
    address               VARCHAR(500)  NOT NULL,
    pin_code              VARCHAR(10)   NOT NULL,
    status                VARCHAR(20)   NOT NULL DEFAULT 'ACTIVE',
    created_at            TIMESTAMP     NOT NULL DEFAULT now(),
    updated_at            TIMESTAMP     NOT NULL DEFAULT now(),
    CONSTRAINT uq_agencies_agency_name UNIQUE (agency_name),
    CONSTRAINT uq_agencies_agency_code UNIQUE (agency_code)
);

-- 2. Ensure admins exists
CREATE TABLE IF NOT EXISTS admins (
    id              BIGSERIAL PRIMARY KEY,
    username        VARCHAR(100)  NOT NULL,
    password_hash   VARCHAR(255)  NOT NULL,
    full_name       VARCHAR(150),
    active          BOOLEAN       NOT NULL DEFAULT TRUE,
    created_at      TIMESTAMP     NOT NULL DEFAULT now(),
    updated_at      TIMESTAMP     NOT NULL DEFAULT now(),
    CONSTRAINT uq_admins_username UNIQUE (username)
);

-- 3. Dedicated app_users table for Survey Officers / Agency Users
CREATE TABLE IF NOT EXISTS app_users (
    id                      BIGSERIAL PRIMARY KEY,
    agency_id               BIGINT        NOT NULL REFERENCES agencies(id),
    full_name                VARCHAR(150)  NOT NULL,
    mobile_no                VARCHAR(15)   NOT NULL,
    email                     VARCHAR(150)  NOT NULL,
    aadhaar_no_encrypted      VARCHAR(255)  NOT NULL,
    aadhaar_no_hash           VARCHAR(64)   NOT NULL,
    address                   VARCHAR(500)  NOT NULL,
    pin_code                  VARCHAR(10)   NOT NULL,
    photo_path                VARCHAR(500),
    password_hash             VARCHAR(255)  NOT NULL,
    role                      VARCHAR(30)   NOT NULL DEFAULT 'SURVEY_OFFICER',
    status                    VARCHAR(20)   NOT NULL DEFAULT 'INACTIVE',
    mobile_verified           BOOLEAN       NOT NULL DEFAULT FALSE,
    aadhaar_verified          BOOLEAN       NOT NULL DEFAULT FALSE,
    created_at                TIMESTAMP     NOT NULL DEFAULT now(),
    updated_at                TIMESTAMP     NOT NULL DEFAULT now(),
    CONSTRAINT uq_app_users_email UNIQUE (email),
    CONSTRAINT uq_app_users_mobile_no UNIQUE (mobile_no),
    CONSTRAINT uq_app_users_aadhaar_no_hash UNIQUE (aadhaar_no_hash)
);

CREATE INDEX IF NOT EXISTS idx_app_users_agency_id ON app_users(agency_id);

-- 4. Re-link or recreate otp_verifications for app_users
DO $$
BEGIN
    IF EXISTS (
        SELECT 1 FROM information_schema.tables WHERE table_name = 'otp_verifications'
    ) THEN
        -- If otp_verifications exists but references legacy 'users' table, drop it so it can be cleanly recreated
        IF EXISTS (
            SELECT 1 FROM information_schema.table_constraints tc
            JOIN information_schema.constraint_column_usage ccu ON tc.constraint_name = ccu.constraint_name
            WHERE tc.table_name = 'otp_verifications' AND ccu.table_name = 'users'
        ) THEN
            DROP TABLE otp_verifications;
        END IF;
    END IF;
END $$;

CREATE TABLE IF NOT EXISTS otp_verifications (
    id                BIGSERIAL PRIMARY KEY,
    user_id            BIGINT        NOT NULL REFERENCES app_users(id),
    otp_hash           VARCHAR(255)  NOT NULL,
    purpose            VARCHAR(30)   NOT NULL,
    expires_at          TIMESTAMP     NOT NULL,
    attempt_count       INT           NOT NULL DEFAULT 0,
    resend_count        INT           NOT NULL DEFAULT 0,
    verified            BOOLEAN       NOT NULL DEFAULT FALSE,
    last_sent_at         TIMESTAMP     NOT NULL DEFAULT now(),
    created_at           TIMESTAMP     NOT NULL DEFAULT now(),
    updated_at           TIMESTAMP     NOT NULL DEFAULT now()
);

CREATE INDEX IF NOT EXISTS idx_otp_user_id ON otp_verifications(user_id);
