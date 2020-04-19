-- -----------------------------------------------------
-- Table dbo.ChangeHistory
-- -----------------------------------------------------
DROP TABLE IF EXISTS dbo.ChangeHistory 
GO

CREATE TABLE dbo.ChangeHistory (
  ChangeHistoryId INT NOT NULL,
  ChangeHistoryDate DATETIME NULL,
  ChangeHistoryUserId INT NOT NULL,
  ChangeHistoryInfo NVARCHAR(MAX) NULL,
  PRIMARY KEY (ChangeHistoryId),
  INDEX fk_ChangeHistory_Users1_idx (ChangeHistoryUserId ASC),
  )
GO

-- -----------------------------------------------------
-- Table dbo.OrgUnit
-- -----------------------------------------------------
DROP TABLE IF EXISTS dbo.OrgUnit 

CREATE TABLE dbo.OrgUnit (
  OrgUnitId INT NOT NULL,
  OrgUnitFullName VARCHAR(100) NULL,
  OrgUnitShartName VARCHAR(30) NULL,
  PRIMARY KEY (OrgUnitId))
GO

-- -----------------------------------------------------
-- Table dbo.Packs
-- -----------------------------------------------------
DROP TABLE IF EXISTS dbo.Packs 

CREATE TABLE dbo.Packs (
  PackId INT NOT NULL,
  CreatedBy INT NOT NULL,
  CreationDate DATETIME NULL,
  PackName VARCHAR(100) NULL,
  PackDescription VARCHAR(1000) NULL,
  PackTime INT NULL,
  PRIMARY KEY (PackId),
  INDEX fk_Packs_Users1_idx (CreatedBy ASC),
  )
GO

-- -----------------------------------------------------
-- Table dbo.PacksSendings
-- -----------------------------------------------------
DROP TABLE IF EXISTS dbo.PacksSendings 

CREATE TABLE dbo.PacksSendings (
  SendingId INT NOT NULL,
  PackId INT NOT NULL,
  SendingDate DATETIME NULL,
  SendingEmail VARCHAR(100) NULL,
  PRIMARY KEY (SendingId),
  INDEX fk_PacksSends_Packs1_idx (PackId ASC),
  )
GO


-- -----------------------------------------------------
-- Table dbo.Schemes
-- -----------------------------------------------------
DROP TABLE IF EXISTS dbo.Schemes 

CREATE TABLE dbo.Schemes (
  SchemeId INT NOT NULL,
  SchemeName VARCHAR(50) NULL,
  SchemeAlias VARCHAR(50) NULL,
  CreationDate DATETIME NULL,
  CratedBy INT NOT NULL,
  PRIMARY KEY (SchemeId),
  INDEX fk_Schemes_Users1_idx (CratedBy ASC),
  )
GO


-- -----------------------------------------------------
-- Table dbo.Tags
-- -----------------------------------------------------
DROP TABLE IF EXISTS dbo.Tags 

CREATE TABLE dbo.Tags (
  TagId INT NOT NULL,
  TagName VARCHAR(45) NOT NULL UNIQUE,
  CreationDate DATETIME NULL,
  CreatedBy INT NOT NULL,
  PRIMARY KEY (TagId),
  INDEX fk_Tags_Users1_idx (CreatedBy ASC)
  )
GO

-- -----------------------------------------------------
-- Table dbo.Tasks
-- -----------------------------------------------------
DROP TABLE IF EXISTS dbo.Tasks 

CREATE TABLE dbo.Tasks (
  TaskId INT NOT NULL,
  CreatedBy INT NOT NULL,
  CreationDate DATETIME NULL,
  SchemeId INT NOT NULL,
  TaskName VARCHAR(100) NULL,
  TaskString NVARCHAR(4000) NULL,
  TaskImage NVARCHAR(MAX) NULL,
  TaskAnswer NVARCHAR(4000) NULL,
  TaskTime INT NULL,
  PRIMARY KEY (TaskId),
  INDEX fk_Tasks_Users1_idx (CreatedBy ASC),
  INDEX fk_Tasks_Schemes1_idx (SchemeId ASC),
  )
GO


-- -----------------------------------------------------
-- Table dbo.TasksOfPacks
-- -----------------------------------------------------
DROP TABLE IF EXISTS dbo.TasksOfPacks 

CREATE TABLE dbo.TasksOfPacks (
  TasksOfPacksId INT NOT NULL,
  TaskId INT NOT NULL,
  PackId INT NOT NULL,
  PRIMARY KEY (TasksOfPacksId),
  INDEX fk_TasksOfPacks_Tasks1_idx (TaskId ASC),
  INDEX fk_TasksOfPacks_Packs1_idx (PackId ASC),
  )
GO


-- -----------------------------------------------------
-- Table dbo.TaskTags
-- -----------------------------------------------------
DROP TABLE IF EXISTS dbo.TaskTags 

CREATE TABLE dbo.TaskTags (
  TagLinkId INT NOT NULL,
  TagId INT NOT NULL,
  TaskId INT NOT NULL,
  PRIMARY KEY (TagLinkId),
  INDEX fk_TaskTags_Tags_idx (TagId ASC),
  INDEX fk_TaskTags_Tasks1_idx (TaskId ASC),
  )
GO


-- -----------------------------------------------------
-- Table dbo.TestResults
-- -----------------------------------------------------
DROP TABLE IF EXISTS dbo.TestResults 

CREATE TABLE dbo.TestResults (
  ResultId INT NOT NULL,
  SendingId INT NOT NULL,
  TaskId INT NOT NULL,
  Result TINYINT NULL,
  CandidatesAnswer NVARCHAR(4000) NULL,
  PRIMARY KEY (ResultId),
  INDEX fk_TestResults_PacksSends1_idx (SendingId ASC),
  INDEX fk_TestResults_Tasks1_idx (TaskId ASC),
  )
GO


-- -----------------------------------------------------
-- Table dbo.Users
-- -----------------------------------------------------
DROP TABLE IF EXISTS dbo.Users 
GO

CREATE TABLE dbo.Users (
  UserId INT NOT NULL,
  Login NVARCHAR(100) NULL,
  Password NVARCHAR(45) NULL,
  OrgUnitId INT NOT NULL,
  LastLogin DATETIME NULL,
  UserInfo VARCHAR(45) NULL,
  PRIMARY KEY (UserId),
  INDEX fk_Users_OrgUnit1_idx (OrgUnitId ASC),
  )
GO

-- -----------------------------------------------------
-- FOREIGN KEYS
-- -----------------------------------------------------
ALTER TABLE dbo.ChangeHistory
ADD CONSTRAINT fk_ChangeHistory_Users1
    FOREIGN KEY (ChangeHistoryUserId)
    REFERENCES dbo.Users (UserId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
GO

ALTER TABLE dbo.Users
ADD CONSTRAINT fk_Users_OrgUnit1
    FOREIGN KEY (OrgUnitId)
    REFERENCES dbo.OrgUnit (OrgUnitId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
GO

ALTER TABLE dbo.Packs
ADD CONSTRAINT fk_Packs_Users1
    FOREIGN KEY (CreatedBy)
    REFERENCES dbo.Users (UserId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
GO

ALTER TABLE dbo.PacksSendings
ADD CONSTRAINT fk_PacksSends_Packs1
    FOREIGN KEY (PackId)
    REFERENCES dbo.Packs (PackId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
GO

ALTER TABLE dbo.Schemes
ADD CONSTRAINT fk_Schemes_Users1
    FOREIGN KEY (CratedBy)
    REFERENCES dbo.Users (UserId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
GO

ALTER TABLE dbo.Tags
ADD CONSTRAINT fk_Tags_Users1
    FOREIGN KEY (CreatedBy)
    REFERENCES dbo.Users (UserId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
GO

ALTER TABLE dbo.Tasks
ADD CONSTRAINT fk_Tasks_Users1
    FOREIGN KEY (CreatedBy)
    REFERENCES dbo.Users (UserId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
GO

ALTER TABLE dbo.Tasks
ADD CONSTRAINT fk_Tasks_Schemes1
    FOREIGN KEY (SchemeId)
    REFERENCES dbo.Schemes (SchemeId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
GO

ALTER TABLE dbo.TasksOfPacks
ADD CONSTRAINT fk_TasksOfPacks_Tasks1
    FOREIGN KEY (TaskId)
    REFERENCES dbo.Tasks (TaskId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
GO

ALTER TABLE dbo.TasksOfPacks
ADD CONSTRAINT fk_TasksOfPacks_Packs1
    FOREIGN KEY (PackId)
    REFERENCES dbo.Packs (PackId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
GO

ALTER TABLE dbo.TaskTags
ADD CONSTRAINT fk_TaskTags_Tags
    FOREIGN KEY (TagId)
    REFERENCES dbo.Tags (TagId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
GO

ALTER TABLE dbo.TaskTags
ADD CONSTRAINT fk_TaskTags_Tasks1
    FOREIGN KEY (TaskId)
    REFERENCES dbo.Tasks (TaskId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
GO

ALTER TABLE dbo.TestResults
ADD CONSTRAINT fk_TestResults_PacksSends1
    FOREIGN KEY (SendingId)
    REFERENCES dbo.PacksSendings (SendingId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
GO

ALTER TABLE dbo.TestResults
ADD CONSTRAINT fk_TestResults_Tasks1
    FOREIGN KEY (TaskId)
    REFERENCES dbo.Tasks (TaskId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
GO