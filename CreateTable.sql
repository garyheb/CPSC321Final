
DROP TABLE IF EXISTS Offensive_Player;
DROP TABLE IF EXISTS Defensive_Player;
DROP TABLE IF EXISTS Quarterback;
DROP TABLE IF EXISTS Head_Coach;
DROP TABLE IF EXISTS Team;


CREATE TABLE Team (
	Team_Name      VARCHAR(30),
    Wins           TINYINT UNSIGNED NOT NULL DEFAULT 0,
    Losses         TINYINT UNSIGNED NOT NULL DEFAULT 0,
    Draws          TINYINT UNSIGNED NOT NULL DEFAULT 0,
    Superbowl_Wins TINYINT UNSIGNED NOT NULL DEFAULT 0,
    Season	       SMALLINT UNSIGNED,
    PRIMARY KEY(Team_Name, Season)
);


CREATE TABLE Offensive_Player(
	Player_Name	      VARCHAR(30),
	Birthday	      date,
	Jersey_Number	  TINYINT UNSIGNED NOT NULL,
    Touchdowns        SMALLINT UNSIGNED DEFAULT 0,
    Passing_Yards     MEDIUMINT SIGNED DEFAULT  0, /*signed small int becasue of the possibility for a quarterback being sacked on their only play in a season*/
    Rushing_Yards     MEDIUMINT SIGNED DEFAULT  0,
    Turnovers         SMALLINT UNSIGNED DEFAULT 0,
    Position          VARCHAR(20),
    Season	          SMALLINT UNSIGNED,
    Team_Name         VARCHAR(25),
    PRIMARY KEY (Player_Name, Birthday, Season),
    FOREIGN KEY (Team_Name) REFERENCES Team(Team_Name)
);


CREATE TABLE Defensive_Player(
	Player_Name	      VARCHAR(30),
	Birthday	      date,
	Jersey_Number	  TINYINT UNSIGNED NOT NULL,
    Touchdowns        SMALLINT UNSIGNED DEFAULT 0,
    Rushing_Yards     MEDIUMINT SIGNED DEFAULT  0,
    Sacks             SMALLINT UNSIGNED DEFAULT 0,
    Tackles           SMALLINT UNSIGNED DEFAULT 0,
	Interceptions     SMALLINT UNSIGNED DEFAULT 0,
    Position          VARCHAR(20),
    Season	          SMALLINT UNSIGNED,
    Team_Name         VARCHAR(25),
    PRIMARY KEY (Player_Name, Birthday, Season),
    FOREIGN KEY (Team_Name) REFERENCES Team(Team_Name)
);


CREATE TABLE Quarterback(
	Player_Name	  VARCHAR(30),
	Birthday	      date,
	Jersey_Number	  TINYINT UNSIGNED NOT NULL,
    Passing_Yards     MEDIUMINT SIGNED DEFAULT  0, /*signed small int becasue of the possibility for a quarterback being sacked on their only play in a season*/
    Rushing_Yards     MEDIUMINT SIGNED DEFAULT  0,
    Times_Sacked      SMALLINT UNSIGNED DEFAULT 0,
    Interceptions     SMALLINT UNSIGNED DEFAULT 0,
	Fumbles           SMALLINT UNSIGNED DEFAULT 0,
	Passing_TD        SMALLINT UNSIGNED DEFAULT 0,
	Rushing_TD        SMALLINT UNSIGNED DEFAULT 0,
	Completion_Perc   SMALLINT UNSIGNED DEFAULT 0,
	Passes_Attempted  SMALLINT UNSIGNED DEFAULT 0,
	Passes_Completed  SMALLINT UNSIGNED DEFAULT 0,
    Position          VARCHAR(20),
    Season	          SMALLINT UNSIGNED,
    Team_Name         VARCHAR(25),
    PRIMARY KEY (Player_Name, Birthday, Season),
    FOREIGN KEY (Team_Name) REFERENCES Team(Team_Name)
);


CREATE TABLE Head_Coach (
	Coach_Name		 VARCHAR(30),
    Superbowl_Wins   TINYINT UNSIGNED  NOT NULL DEFAULT 0,
    Season			 SMALLINT UNSIGNED NOT NULL,
    Team_Name   	 VARCHAR(25),
    PRIMARY KEY(Coach_Name, Season),
    FOREIGN KEY(Team_Name) REFERENCES Team(Team_Name)
);