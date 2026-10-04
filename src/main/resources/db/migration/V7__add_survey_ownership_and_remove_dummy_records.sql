ALTER TABLE surveys
    ADD COLUMN IF NOT EXISTS created_by_user_id BIGINT;

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM pg_constraint WHERE conname = 'fk_surveys_created_by_user'
    ) THEN
        ALTER TABLE surveys
            ADD CONSTRAINT fk_surveys_created_by_user
            FOREIGN KEY (created_by_user_id) REFERENCES users(id) ON DELETE SET NULL;
    END IF;
END $$;

CREATE INDEX IF NOT EXISTS idx_surveys_created_by_user_id
    ON surveys(created_by_user_id);

-- Remove the sample surveys shipped with the original demo dataset only.
DELETE FROM surveys
WHERE id IN (
    'BWG-2026-48192',
    'BWG-2026-51920',
    'BWG-2026-62018',
    'BWG-2026-73910',
    'BWG-2026-73911',
    'BWG-2026-88201',
    'BWG-2026-90142',
    'BWG-2026-30219',
    'BWG-2026-44102'
);
