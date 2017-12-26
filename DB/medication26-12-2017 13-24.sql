#
# TABLE STRUCTURE FOR: medication
#

DROP TABLE IF EXISTS medication;

CREATE TABLE `medication` (
  `MID` mediumint(9) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MID`)
) ENGINE=InnoDB AUTO_INCREMENT=12099 DEFAULT CHARSET=latin1;

INSERT INTO medication (`MID`, `Name`) VALUES (12000, 'Abilify');
INSERT INTO medication (`MID`, `Name`) VALUES (12001, 'Humira');
INSERT INTO medication (`MID`, `Name`) VALUES (12002, 'Nexium');
INSERT INTO medication (`MID`, `Name`) VALUES (12003, 'Crestor');
INSERT INTO medication (`MID`, `Name`) VALUES (12004, 'Enbrel');
INSERT INTO medication (`MID`, `Name`) VALUES (12005, 'Advair Diskus, Seretide');
INSERT INTO medication (`MID`, `Name`) VALUES (12006, 'Remicade');
INSERT INTO medication (`MID`, `Name`) VALUES (12007, 'Lantus Solostar');
INSERT INTO medication (`MID`, `Name`) VALUES (12008, 'Neulasta');
INSERT INTO medication (`MID`, `Name`) VALUES (12009, 'Copaxone');
INSERT INTO medication (`MID`, `Name`) VALUES (12010, 'Rituxan, MabThera');
INSERT INTO medication (`MID`, `Name`) VALUES (12011, 'Spiriva');
INSERT INTO medication (`MID`, `Name`) VALUES (12012, 'Januvia');
INSERT INTO medication (`MID`, `Name`) VALUES (12013, 'Lantus');
INSERT INTO medication (`MID`, `Name`) VALUES (12014, 'Atripla');
INSERT INTO medication (`MID`, `Name`) VALUES (12015, 'Cymbalta');
INSERT INTO medication (`MID`, `Name`) VALUES (12016, 'Avastin');
INSERT INTO medication (`MID`, `Name`) VALUES (12017, 'Lyrica');
INSERT INTO medication (`MID`, `Name`) VALUES (12018, 'OxyContin');
INSERT INTO medication (`MID`, `Name`) VALUES (12019, 'Celebrex');
INSERT INTO medication (`MID`, `Name`) VALUES (12020, 'Epogen');
INSERT INTO medication (`MID`, `Name`) VALUES (12021, 'Truvada');
INSERT INTO medication (`MID`, `Name`) VALUES (12022, 'Diovan');
INSERT INTO medication (`MID`, `Name`) VALUES (12023, 'Levemir');
INSERT INTO medication (`MID`, `Name`) VALUES (12024, 'Gleevec, Glivec');
INSERT INTO medication (`MID`, `Name`) VALUES (12025, 'Herceptin');
INSERT INTO medication (`MID`, `Name`) VALUES (12026, 'Vyvanse');
INSERT INTO medication (`MID`, `Name`) VALUES (12027, 'Lucentis');
INSERT INTO medication (`MID`, `Name`) VALUES (12028, 'Zetia');
INSERT INTO medication (`MID`, `Name`) VALUES (12029, 'Combivent');
INSERT INTO medication (`MID`, `Name`) VALUES (12030, 'Symbicort');
INSERT INTO medication (`MID`, `Name`) VALUES (12031, 'Namenda');
INSERT INTO medication (`MID`, `Name`) VALUES (12032, 'NovoLog FlexPen');
INSERT INTO medication (`MID`, `Name`) VALUES (12033, 'Xarelto');
INSERT INTO medication (`MID`, `Name`) VALUES (12034, 'NovoLog');
INSERT INTO medication (`MID`, `Name`) VALUES (12035, 'Humalog');
INSERT INTO medication (`MID`, `Name`) VALUES (12036, 'Suboxone');
INSERT INTO medication (`MID`, `Name`) VALUES (12037, 'Viagra');
INSERT INTO medication (`MID`, `Name`) VALUES (12038, 'Seroquel XR');
INSERT INTO medication (`MID`, `Name`) VALUES (12039, 'ONE TOUCH ULTRA');
INSERT INTO medication (`MID`, `Name`) VALUES (12040, 'AndroGel');
INSERT INTO medication (`MID`, `Name`) VALUES (12041, 'Enoxaparin');
INSERT INTO medication (`MID`, `Name`) VALUES (12042, 'Ritalin');
INSERT INTO medication (`MID`, `Name`) VALUES (12043, 'ProAir HFA');
INSERT INTO medication (`MID`, `Name`) VALUES (12044, 'Alimta');
INSERT INTO medication (`MID`, `Name`) VALUES (12045, 'Victoza');
INSERT INTO medication (`MID`, `Name`) VALUES (12046, 'Synagis');
INSERT INTO medication (`MID`, `Name`) VALUES (12047, 'Avonex');
INSERT INTO medication (`MID`, `Name`) VALUES (12048, 'Renvela');
INSERT INTO medication (`MID`, `Name`) VALUES (12049, 'Rebif');
INSERT INTO medication (`MID`, `Name`) VALUES (12050, 'Cialis');
INSERT INTO medication (`MID`, `Name`) VALUES (12051, 'Gilenya');
INSERT INTO medication (`MID`, `Name`) VALUES (12052, 'Nasonex');
INSERT INTO medication (`MID`, `Name`) VALUES (12053, 'Stelara');
INSERT INTO medication (`MID`, `Name`) VALUES (12054, 'Restasis');
INSERT INTO medication (`MID`, `Name`) VALUES (12055, 'Budesonide');
INSERT INTO medication (`MID`, `Name`) VALUES (12056, 'Acetaminophen/hydrocodone');
INSERT INTO medication (`MID`, `Name`) VALUES (12057, 'Flovent HFA');
INSERT INTO medication (`MID`, `Name`) VALUES (12058, 'Lovaza');
INSERT INTO medication (`MID`, `Name`) VALUES (12059, 'Prezista');
INSERT INTO medication (`MID`, `Name`) VALUES (12060, 'Isentress');
INSERT INTO medication (`MID`, `Name`) VALUES (12061, 'Janumet');
INSERT INTO medication (`MID`, `Name`) VALUES (12062, 'Procrit, Eprex');
INSERT INTO medication (`MID`, `Name`) VALUES (12063, 'Doxycycline');
INSERT INTO medication (`MID`, `Name`) VALUES (12064, 'Orencia');
INSERT INTO medication (`MID`, `Name`) VALUES (12065, 'Amphetamine/dextroamphetamine');
INSERT INTO medication (`MID`, `Name`) VALUES (12066, 'Vesicare');
INSERT INTO medication (`MID`, `Name`) VALUES (12067, 'Dexilant');
INSERT INTO medication (`MID`, `Name`) VALUES (12068, 'Humalog KwikPen');
INSERT INTO medication (`MID`, `Name`) VALUES (12069, 'Neupogen');
INSERT INTO medication (`MID`, `Name`) VALUES (12070, 'Lidocaine');
INSERT INTO medication (`MID`, `Name`) VALUES (12071, 'Lunesta');
INSERT INTO medication (`MID`, `Name`) VALUES (12072, 'Fenofibrate');
INSERT INTO medication (`MID`, `Name`) VALUES (12073, 'Zytiga');
INSERT INTO medication (`MID`, `Name`) VALUES (12074, 'Reyataz');
INSERT INTO medication (`MID`, `Name`) VALUES (12075, 'Sensipar');
INSERT INTO medication (`MID`, `Name`) VALUES (12076, 'Metoprolol');
INSERT INTO medication (`MID`, `Name`) VALUES (12077, 'AcipHex');
INSERT INTO medication (`MID`, `Name`) VALUES (12078, 'Synthroid');
INSERT INTO medication (`MID`, `Name`) VALUES (12079, 'Avonex Pen');
INSERT INTO medication (`MID`, `Name`) VALUES (12080, 'Prevnar 13');
INSERT INTO medication (`MID`, `Name`) VALUES (12081, 'Xolair');
INSERT INTO medication (`MID`, `Name`) VALUES (12082, 'Lipitor');
INSERT INTO medication (`MID`, `Name`) VALUES (12083, 'levothyroxine');
INSERT INTO medication (`MID`, `Name`) VALUES (12084, 'Benicar');
INSERT INTO medication (`MID`, `Name`) VALUES (12085, 'Stribild');
INSERT INTO medication (`MID`, `Name`) VALUES (12086, 'Zostavax');
INSERT INTO medication (`MID`, `Name`) VALUES (12087, 'Pradaxa');
INSERT INTO medication (`MID`, `Name`) VALUES (12088, 'Vytorin');
INSERT INTO medication (`MID`, `Name`) VALUES (12089, 'Tamiflu');
INSERT INTO medication (`MID`, `Name`) VALUES (12090, 'Xgeva');
INSERT INTO medication (`MID`, `Name`) VALUES (12091, 'Evista');
INSERT INTO medication (`MID`, `Name`) VALUES (12092, 'Xeloda');
INSERT INTO medication (`MID`, `Name`) VALUES (12093, 'Aranesp');
INSERT INTO medication (`MID`, `Name`) VALUES (12094, 'Ventolin HFA');
INSERT INTO medication (`MID`, `Name`) VALUES (12095, 'divalproex sodium');
INSERT INTO medication (`MID`, `Name`) VALUES (12096, 'Afinitor');
INSERT INTO medication (`MID`, `Name`) VALUES (12097, 'Betaseron, Betaferon');
INSERT INTO medication (`MID`, `Name`) VALUES (12098, 'Adderall XR');
INSERT INTO medication (`MID`, `Name`) VALUES (12099, 'Complera d');
