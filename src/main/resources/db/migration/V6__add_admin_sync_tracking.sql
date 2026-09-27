-- Tracks whether a survey has actually reached the admin backend via
-- AdminBridgeClient. Null means "not yet synced" (either never attempted,
-- or every attempt so far failed) - a scheduled retry job re-pushes every
-- survey in that state until it succeeds, instead of the previous
-- fire-and-forget push where a failure (admin backend down, network
-- blip) meant the survey was silently never sent again.
ALTER TABLE surveys ADD COLUMN IF NOT EXISTS admin_synced_at TIMESTAMP;
CREATE INDEX IF NOT EXISTS idx_surveys_admin_synced_at ON surveys(admin_synced_at) WHERE admin_synced_at IS NULL;
