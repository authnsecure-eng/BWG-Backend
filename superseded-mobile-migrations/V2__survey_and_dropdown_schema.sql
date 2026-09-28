-- V2: Database schema for Surveys, Waste Visits, and Seeded Dropdowns

-- 1. DROPDOWN OPTIONS TABLE
CREATE TABLE dropdown_options (
    id              BIGSERIAL PRIMARY KEY,
    category_group  VARCHAR(50)  NOT NULL,
    parent_value    VARCHAR(100),
    option_label    VARCHAR(255) NOT NULL,
    option_value    VARCHAR(255) NOT NULL,
    sort_order      INT          NOT NULL DEFAULT 0,
    active          BOOLEAN      NOT NULL DEFAULT TRUE
);

CREATE INDEX idx_dropdown_group ON dropdown_options(category_group);
CREATE INDEX idx_dropdown_parent ON dropdown_options(parent_value);

-- 2. SURVEYS TABLE
CREATE TABLE surveys (
    id                               VARCHAR(50)  PRIMARY KEY,
    category                         VARCHAR(30)  NOT NULL,
    status                           VARCHAR(20)  NOT NULL DEFAULT 'pending',
    is_bwg                           BOOLEAN      NOT NULL DEFAULT FALSE,
    establishment_name               VARCHAR(255) NOT NULL,
    zone                             VARCHAR(100) NOT NULL,
    ward                             VARCHAR(100) NOT NULL,
    electoral_ward                   VARCHAR(100),
    contact_name                     VARCHAR(150) NOT NULL,
    contact_designation              VARCHAR(100) NOT NULL,
    contact_mobile                   VARCHAR(20)  NOT NULL,
    contact_email                    VARCHAR(150),
    contact_address                  TEXT         NOT NULL,
    contact_pincode                  VARCHAR(10)  NOT NULL,
    year_established                 VARCHAR(10),
    premises_photo_url               VARCHAR(500),
    premises_photo_geo               VARCHAR(255),
    premises_photo_time              VARCHAR(100),
    gps_coordinates                  VARCHAR(255),
    sub_category_type                VARCHAR(150),
    society_name                     VARCHAR(255),
    chs_reg_no                       VARCHAR(100),
    org_name                         VARCHAR(255),
    cin_number                       VARCHAR(100),
    trade_license_no                 VARCHAR(100),
    total_floors                     VARCHAR(20),
    total_units                      VARCHAR(20),
    built_up_area_sq_m               NUMERIC(12, 2) DEFAULT 0,
    building_remarks                 TEXT,
    building_permission_doc_url      VARCHAR(500) NOT NULL,
    building_permission_geo          VARCHAR(255),
    building_permission_time         VARCHAR(100),
    water_consumer_no                VARCHAR(100),
    daily_water_consumption_liters   NUMERIC(12, 2) DEFAULT 0,
    water_bill_doc_url               VARCHAR(500),
    bin_infrastructure               VARCHAR(50),
    segregated_at_source             VARCHAR(50),
    dry_waste_channelized_to         VARCHAR(150),
    has_biogas_plant                 BOOLEAN      DEFAULT FALSE,
    biogas_capacity                  VARCHAR(50),
    biogas_capacity_unit             VARCHAR(50),
    biogas_operational_status        VARCHAR(50),
    biogas_photo_url                 VARCHAR(500),
    biogas_remarks                   TEXT,
    geofence_latitude                VARCHAR(50),
    geofence_longitude               VARCHAR(50),
    geofence_photo_url               VARCHAR(500),
    eligibility_floor_area           BOOLEAN      DEFAULT FALSE,
    eligibility_water_consumption    BOOLEAN      DEFAULT FALSE,
    eligibility_solid_waste          BOOLEAN      DEFAULT FALSE,
    declarant_name                   VARCHAR(150),
    declarant_designation            VARCHAR(100),
    declarant_org_name               VARCHAR(255),
    declarant_date                   VARCHAR(30),
    declarant_place                  VARCHAR(150),
    declaration_file_url             VARCHAR(500),
    declaration_file_geo             VARCHAR(255),
    declaration_file_time            VARCHAR(100),
    surveyor_name                    VARCHAR(150),
    surveyor_selfie_url              VARCHAR(500),
    surveyor_gps                     VARCHAR(255),
    surveyor_timestamp               VARCHAR(100),
    surveyor_verified                BOOLEAN      DEFAULT FALSE,
    avg_wet_waste_kg                 NUMERIC(10, 2) DEFAULT 0,
    avg_dry_waste_kg                 NUMERIC(10, 2) DEFAULT 0,
    avg_total_waste_kg               NUMERIC(10, 2) DEFAULT 0,
    cpcb_completed                   BOOLEAN      DEFAULT FALSE,
    cpcb_ack_number                  VARCHAR(100),
    cpcb_submission_date             VARCHAR(50),
    created_at                       TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at                       TIMESTAMP    NOT NULL DEFAULT now()
);

CREATE INDEX idx_surveys_category ON surveys(category);
CREATE INDEX idx_surveys_status ON surveys(status);
CREATE INDEX idx_surveys_zone ON surveys(zone);
CREATE INDEX idx_surveys_ward ON surveys(ward);

-- 3. SURVEY WASTE VISITS TABLE (3-Day Visit Tracking)
CREATE TABLE survey_waste_visits (
    id                      BIGSERIAL    PRIMARY KEY,
    survey_id               VARCHAR(50)  NOT NULL REFERENCES surveys(id) ON DELETE CASCADE,
    day_number              INT          NOT NULL,
    visit_date              VARCHAR(50),
    wet_waste_kg            NUMERIC(10, 2) DEFAULT 0,
    dry_waste_kg            NUMERIC(10, 2) DEFAULT 0,
    garden_waste_kg         NUMERIC(10, 2) DEFAULT 0,
    total_waste_kg          NUMERIC(10, 2) DEFAULT 0,
    wet_waste_photo_url     VARCHAR(500),
    dry_waste_photo_url     VARCHAR(500),
    garden_waste_photo_url  VARCHAR(500),
    is_completed            BOOLEAN      DEFAULT FALSE,
    created_at              TIMESTAMP    NOT NULL DEFAULT now(),
    CONSTRAINT uq_survey_day UNIQUE (survey_id, day_number)
);

CREATE INDEX idx_waste_visits_survey ON survey_waste_visits(survey_id);

-- 4. SEED DATA FOR DROPDOWNS
INSERT INTO dropdown_options (category_group, parent_value, option_label, option_value, sort_order) VALUES
-- Zones
('ZONE', NULL, 'Zone A', 'Zone A', 1),
('ZONE', NULL, 'Zone B', 'Zone B', 2),
('ZONE', NULL, 'Zone C', 'Zone C', 3),
('ZONE', NULL, 'Zone D', 'Zone D', 4),
('ZONE', NULL, 'Zone E', 'Zone E', 5),
('ZONE', NULL, 'Zone F', 'Zone F', 6),
('ZONE', NULL, 'Zone G', 'Zone G', 7),
('ZONE', NULL, 'Zone H', 'Zone H', 8),

-- Wards (Zone A)
('WARD', 'Zone A', 'Ward 1 - Akurdi', 'Ward 1 - Akurdi', 1),
('WARD', 'Zone A', 'Ward 2 - Nigdi', 'Ward 2 - Nigdi', 2),
-- Wards (Zone B)
('WARD', 'Zone B', 'Ward 3 - Chinchwad', 'Ward 3 - Chinchwad', 1),
('WARD', 'Zone B', 'Ward 4 - Thergaon', 'Ward 4 - Thergaon', 2),
-- Wards (Zone C)
('WARD', 'Zone C', 'Ward 5 - Pimpri', 'Ward 5 - Pimpri', 1),
('WARD', 'Zone C', 'Ward 6 - Kalewadi', 'Ward 6 - Kalewadi', 2),
-- Wards (Zone D)
('WARD', 'Zone D', 'Ward 7 - Bhosari', 'Ward 7 - Bhosari', 1),
('WARD', 'Zone D', 'Ward 8 - Indrayani Nagar', 'Ward 8 - Indrayani Nagar', 2),
-- Wards (Zone E)
('WARD', 'Zone E', 'Ward 9 - Sangvi', 'Ward 9 - Sangvi', 1),
('WARD', 'Zone E', 'Ward 10 - Dapodi', 'Ward 10 - Dapodi', 2),
-- Wards (Zone F)
('WARD', 'Zone F', 'Ward 11 - Wakad', 'Ward 11 - Wakad', 1),
('WARD', 'Zone F', 'Ward 12 - Pimple Saudagar', 'Ward 12 - Pimple Saudagar', 2),

-- Commercial Subcategories (15 choices)
('COMMERCIAL_SUBCATEGORY', NULL, 'Bus Station / Depot', 'Bus Station / Depot', 1),
('COMMERCIAL_SUBCATEGORY', NULL, 'Railway Station / Railway', 'Railway Station / Railway', 2),
('COMMERCIAL_SUBCATEGORY', NULL, 'Airport', 'Airport', 3),
('COMMERCIAL_SUBCATEGORY', NULL, 'Port / Harbour', 'Port / Harbour', 4),
('COMMERCIAL_SUBCATEGORY', NULL, 'Industrial unit and industrial area', 'Industrial unit and industrial area', 5),
('COMMERCIAL_SUBCATEGORY', NULL, 'Mall', 'Mall', 6),
('COMMERCIAL_SUBCATEGORY', NULL, 'Multiplexe', 'Multiplexe', 7),
('COMMERCIAL_SUBCATEGORY', NULL, 'Hotel', 'Hotel', 8),
('COMMERCIAL_SUBCATEGORY', NULL, 'Restaurant / Food Court', 'Restaurant / Food Court', 9),
('COMMERCIAL_SUBCATEGORY', NULL, 'Wholesale market, like "Mandi", fish market, meat market', 'Wholesale market, like "Mandi", fish market, meat market', 10),
('COMMERCIAL_SUBCATEGORY', NULL, 'Stadium, Sport Complexe', 'Stadium, Sport Complexe', 11),
('COMMERCIAL_SUBCATEGORY', NULL, 'Community Hall, Convention Hall, Marriage or banquet hall, Conference Centre, Expo Centre', 'Community Hall, Convention Hall, Marriage or banquet hall, Conference Centre, Expo Centre', 12),
('COMMERCIAL_SUBCATEGORY', NULL, 'Tourist Spot', 'Tourist Spot', 13),
('COMMERCIAL_SUBCATEGORY', NULL, 'Hospital, Nursing home, Hostel, Auditorium, Exhibition area', 'Hospital, Nursing home, Hostel, Auditorium, Exhibition area', 14),
('COMMERCIAL_SUBCATEGORY', NULL, 'Other', 'Other', 15),

-- Institutional Subcategories (13 choices)
('INSTITUTIONAL_SUBCATEGORY', NULL, 'Central Government department or undertaking', 'Central Government department or undertaking', 1),
('INSTITUTIONAL_SUBCATEGORY', NULL, 'State Government department or undertaking', 'State Government department or undertaking', 2),
('INSTITUTIONAL_SUBCATEGORY', NULL, 'Local body', 'Local body', 3),
('INSTITUTIONAL_SUBCATEGORY', NULL, 'Public sector undertaking (PSU)', 'Public sector undertaking (PSU)', 4),
('INSTITUTIONAL_SUBCATEGORY', NULL, 'Private company', 'Private company', 5),
('INSTITUTIONAL_SUBCATEGORY', NULL, 'School', 'School', 6),
('INSTITUTIONAL_SUBCATEGORY', NULL, 'College', 'College', 7),
('INSTITUTIONAL_SUBCATEGORY', NULL, 'University', 'University', 8),
('INSTITUTIONAL_SUBCATEGORY', NULL, 'Research Institute', 'Research Institute', 9),
('INSTITUTIONAL_SUBCATEGORY', NULL, 'Other educational institution', 'Other educational institution', 10),
('INSTITUTIONAL_SUBCATEGORY', NULL, 'Community place', 'Community place', 11),
('INSTITUTIONAL_SUBCATEGORY', NULL, 'Public building', 'Public building', 12),
('INSTITUTIONAL_SUBCATEGORY', NULL, 'Other', 'Other', 13),

-- Residential Subcategories (2 choices)
('RESIDENTIAL_SUBCATEGORY', NULL, 'Residential Society / RWA', 'Residential Society / RWA', 1),
('RESIDENTIAL_SUBCATEGORY', NULL, 'Other', 'Other', 2),

-- Bin Infrastructure
('BIN_INFRASTRUCTURE', NULL, '4-Bin', '4bin', 1),
('BIN_INFRASTRUCTURE', NULL, '2-Bin', '2bin', 2),
('BIN_INFRASTRUCTURE', NULL, 'None', 'none', 3),

-- Segregation Status
('SEGREGATION_STATUS', NULL, 'Yes', 'yes', 1),
('SEGREGATION_STATUS', NULL, 'Partial', 'partial', 2),
('SEGREGATION_STATUS', NULL, 'Not yet', 'no', 3),

-- Dry Waste Channels
('DRY_WASTE_CHANNEL', NULL, 'Dry Waste Collection Centre', 'Dry Waste Collection Centre', 1),
('DRY_WASTE_CHANNEL', NULL, 'Scrap Dealer / Kabadiwala', 'Scrap Dealer / Kabadiwala', 2),
('DRY_WASTE_CHANNEL', NULL, 'PCMC Dry Waste Vehicle', 'PCMC Dry Waste Vehicle', 3),
('DRY_WASTE_CHANNEL', NULL, 'Others', 'Others', 4);

-- 5. SEED SAMPLE SURVEYS
INSERT INTO surveys (
    id, category, status, is_bwg, establishment_name, zone, ward, contact_name, contact_designation, contact_mobile, contact_email, contact_address, contact_pincode, year_established, premises_photo_url, building_permission_doc_url, built_up_area_sq_m, daily_water_consumption_liters, bin_infrastructure, segregated_at_source, dry_waste_channelized_to, avg_wet_waste_kg, avg_dry_waste_kg, avg_total_waste_kg, cpcb_completed, cpcb_ack_number, cpcb_submission_date
) VALUES (
    'BWG-2026-73910', 'residential', 'approved', TRUE, 'Silver Oak Housing Society', 'Zone D', 'Ward 7 (Bhosari)', 'Vikas Shinde', 'Manager', '9890123456', 'silveroak.bhosari@gmail.com', 'Alandi Road, Bhosari, PCMC', '411039', '2023', 'https://images.unsplash.com/photo-1545324418-cc1a3fa10c00?w=600&auto=format&fit=crop&q=80', 'https://images.unsplash.com/photo-1589829545856-d10d557cf95f?w=600&auto=format&fit=crop&q=80', 25000, 45000, '4bin', 'yes', 'Dry Waste Collection Centre', 75, 45, 120, TRUE, 'CPCB-PCMC-2026-00912', '18/08/2026'
), (
    'BWG-2026-88201', 'commercial', 'approved', TRUE, 'Elpro City Square Mall', 'Zone B', 'Ward 3 (Chinchwad)', 'Anand Deshmukh', 'Operations Head', '9850123984', 'anand.d@elpromall.com', 'Chinchwad Station Road, PCMC', '411033', '2018', 'https://images.unsplash.com/photo-1519642918688-7e43b19245d8?w=600&auto=format&fit=crop&q=80', 'https://images.unsplash.com/photo-1589829545856-d10d557cf95f?w=600&auto=format&fit=crop&q=80', 35000, 50000, '4bin', 'yes', 'Dry Waste Collection Centre', 280, 170, 450, TRUE, 'CPCB-PCMC-2026-01044', '19/08/2026'
);

INSERT INTO survey_waste_visits (survey_id, day_number, visit_date, wet_waste_kg, dry_waste_kg, total_waste_kg, is_completed) VALUES
('BWG-2026-73910', 1, '15/08/2026', 70, 40, 110, TRUE),
('BWG-2026-73910', 2, '16/08/2026', 75, 45, 120, TRUE),
('BWG-2026-73910', 3, '17/08/2026', 80, 50, 130, TRUE);
