-- Add other agency waste handover fields to surveys table
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS waste_given_to_other_agency VARCHAR(255);
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS agency_document_photo_url VARCHAR(500);
