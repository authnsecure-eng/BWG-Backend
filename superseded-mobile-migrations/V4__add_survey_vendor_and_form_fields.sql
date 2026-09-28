-- Migration V4: Add survey vendor, processing, and mobile form synchronization fields

-- 1. Vendor and disposal mode fields (surveys table)
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS overall_disposal_mode VARCHAR(100);
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS vendor_name VARCHAR(255);
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS mou_validity VARCHAR(100);
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS processing_destination VARCHAR(255);
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS private_vendor_details VARCHAR(500);

-- 2. Processing facility & biogas extra fields (surveys table)
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS processing_method VARCHAR(100);
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS space_available_sq_meters VARCHAR(50);
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS by_product_usage VARCHAR(255);

-- 3. Tax / Business ID fields (surveys table)
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS ptin VARCHAR(100);
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS gstin VARCHAR(100);

-- 4. Signage photo fields (surveys table)
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS signage_photo_url VARCHAR(500);
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS signage_photo_geo VARCHAR(100);
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS signage_photo_time VARCHAR(100);

-- 5. Building permission and water bill extra fields (surveys table)
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS building_permission_ref_no VARCHAR(100);
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS water_billing_period VARCHAR(100);
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS water_units_consumed VARCHAR(100);

-- 6. Geofence radius (surveys table)
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS geofence_radius_meters VARCHAR(50);

-- 7. Survey waste visits extra photos (survey_waste_visits table)
ALTER TABLE survey_waste_visits ADD COLUMN IF NOT EXISTS weighing_scale_photo_url VARCHAR(500);
ALTER TABLE survey_waste_visits ADD COLUMN IF NOT EXISTS handover_area_photo_url VARCHAR(500);
