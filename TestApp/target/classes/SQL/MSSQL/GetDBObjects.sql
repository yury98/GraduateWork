SELECT type_desc AS Object,
	name
FROM sys.objects
WHERE schema_id = SCHEMA_ID('scheme1')