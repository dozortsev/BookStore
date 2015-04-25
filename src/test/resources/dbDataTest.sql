INSERT INTO Author (Id, Name, Surname, DOB)
  VALUES
  (1, 'Arthur', 'Conan Doyle', '1859-04-22'),
  (2, 'William', 'Shakespeare', '1564-09-24'),
  (3, 'Carlos', 'Castaneda', '1925-12-25'),
  (4, 'Charles', 'Bukowski', '1920-09-16');

INSERT INTO Book (Id, Name, Author, Genre, Language, PubDate, Pages, Price, Description)
VALUES
  (
    1, 'Sherlock Holmes and the Case of the Hound of the Baskervilles',
    1, 'Detective', 'English', '2008-01-01', 240, 19.20,
    'This was a really good book and the story of the hound''s legend makes it cooler.
    Sherlock Holmes thought of everything to solve the mystery.
    I don''t quite remember how each and every character is connected, but the overall setup, mystery, and explanation behind everything is very good.'
  ),

  (
    2, 'The Sherlock Holmes Handbook',
    1, 'Detective', 'English', '2009-10-01', 224, 30.19,
    'My name is Sherlock Holmes. It is my business to know what other people don’t know.'
  ),
  (
    3, 'The Teachings of Don Juan: A Yaqui Way of Knowledge',
    3, 'Esoteric', 'English', '1985-03-03', 256, 18.16,
    'A YAQUI WAY OF KNOWLEDGE
    The teachings of don Juan is the story of a remarkable journey: the first awesome steps on the road to becoming a "man of knowledge"
    -- the road that continues with A Separate Reality and Journey to Ixtlan.
    "For me there is only the traveling on paths that have heart, on any path that may have heart.
    There I travel, and the only worthwhile challenge is to traverse its full length.
    And there I travel, looking, looking, breathlessly." -- Don Juan'
  ),
  (
    4, 'The Klingon Hamlet',
    2, 'Science Fiction', 'English', '2001-02-01', 240, 14.46,
    'For too long, readers throughout the Federation have been exposed to The Tragedy of Khamlet,
    Son of the Emperor of Qo''nos, that classic work of Klingon™ literature, only through inadequate and misleading English translations.
    Now at last, thanks to the tireless efforts of the Klingon Language Institute, this powerful drama by the legendary Klingon playwright,
    Wil''yam Shex''pir, can be appreciated in the elegance and glory of its original tongue.
    This invaluable volume contains the complete text of the play, along with an English translation for easy consultation and comparison.
    In addition, an incisive introduction explains the play''s crucial importance in Klingon culture, while copious notes illustrate how the debased English version diverges from the original,
    often distorting and even reversing the actual meaning of the verses.
    Khamlet, the Restored Klingon Version, is a work that belongs in the library of every human who hopes truly to understand what it means to be Klingon.'
  ),
  (
    5, 'Twelfth Night: Third Series',
    2, 'Science Fiction', 'English', '2009-04-01', 341, 14.98,
    'Critically acclaimed as one of Shakespeare''s most complex and intriguing plays,
    Twelfth Night is a classic romantic comedy of mistaken identities.
    In recent years it has returned to the center of critical debate surrounding gender and sexuality.
    The introduction explores the multiple factors that make up the play''s rich textual, theatrical, critical, and cultural history.
    Keir Elam surveys the play''s production and reception, emphasizing the role of the spectator both within the comedy and the playhouse.
    He also discusses the themes of perspective and interpreting visual images, theatric and film adaptations of the play,
    and Twelfth Night''s comedic elements, and provides individual analyses of Malvolio, Sir Toby, Sir Andrew, Feste, Orsino, Olivia, and Viola.
    Editorial craft, casting and the use of music are addressed in the appendices, which also include a list of abbreviations and references,
    a catalog of Shakespeare’s works and works partly by Shakespeare, and citations for the modern productions mentioned in the text, other collated editions of Twelfth Night,
    and other related reading.'
  ),
  (
    6, 'Journey to Ixtlan: The Lessons of Don Juan',
    3, 'Esoteric', 'English', '1991-02-01', 272, 11.86,
    'Originally drawn to Yaqui Indian spiritual leader don Juan Matus for his knowledge of psychotropic plants,
    bestselling author Carlos Castaneda immersed himself in the sorcerer’s magical world.
    Ten years after his first encounter with the shaman,
    Castaneda examines his field notes and comes to understand what don Juan knew all along—psychotropic plants are merely a
    means to understanding alternative realities that one cannot fully embrace on one’s own.
    Journey to Ixtlan introduces these clear new ideas—omitted from Castaneda’s classic volumes The Teachings of Don Juan and A Separate Reality—to the reader for the first time.
    Castaneda explores, as he comes to experience it himself, his own final voyage into the teachings of don Juan, and shares with us what it is like to truly "stop the world"
    and perceive reality on his own terms.'
  ),
  (
    7, 'A Separate Reality',
    3, 'Esoteric', 'English', '1991-09-01', 277, 12.54,
    '"A man of knowledge is free...he has no honor, no dignity, no family, no home, no country, but only life to be lived." --don Juan
    In 1961 a young anthropologist subjected himself to an extraordinary apprenticeship to bring back a fascinating glimpse of a Yaqui Indian''s world of "non-ordinary reality"
    and the difficult and dangerous road a man must travel to become "a man of knowledge."
    Yet on the bring of that world, challenging to all that we believe, he drew back.
    Then in 1968, Carlos Castaneda returned to Mexico, to don Juan and his hallucinogenic drugs,
    and to a world of experience no man from our Western civilization had ever entered before.'
  ),
  (
    8, 'The Power of Silence: Further Lessons of don Juan',
    3, 'Esoteric', 'English', '1991-07-01', 288, 11.85,
    'Millions of readers worldwide have treasured the visionary brilliance of Carlos Castaneda,
    who first explore the world of the Yaqui Indian sorcerer in The Teachings of don Juan.
    Now, at last, don Juan returns in The Power of Silence -- wise, infuriating, capable or working miracles and playing practical jokes,
    but always seeking the wisdom of the warrior.
    The Power of Silence is Castaneda''s most astonishing book to date -- a brilliant flash of knowledge that illuminates the far reaches of the human mind.
    Through don Juan''s mesmerizing stories, the true meaning of sorcery and magic is finally revealed. Honed in the desert of Sonora, the visions of don Juan give us the vital secrets of belief and self-realization that are transcendental and valid for us all.
    It is Castaneda''s unique genius to show us that all wisdom, strength, and power lie within ourselves -- unleashed with marvelous energy and imaginative force in the teachings of don Juan --
    and in the writings of his famous pupil, Carlos Castaneda'
  ),
  (
    9, 'Ham on Rye',
    4, 'Novel', 'English', '2007-02-27', 288, 12.43,
    'In what is widely hailed as the best of his many novels, Charles Bukowski details the long,
    lonely years of his own hardscrabble youth in the raw voice of alter ego Henry Chinaski.
    From a harrowingly cheerless childhood in Germany through acne-riddled high school years and his adolescent discoveries of alcohol,
    women, and the Los Angeles Public Library''s collection of
    D. H. Lawrence, Ham on Rye offers a crude, brutal, and savagely funny portrait of an outcast''s coming-of-age during
    the desperate days of the Great Depression.'
  );


INSERT INTO Client (Password, Email, Name, Surname, Phone, Address)
VALUES
  (64999, 'Kylie_Jacobs@jazlyn.biz', 'Marietta', 'Shields', '094580843','Puerto Rico, Medahaven'),
(50388, 'Gonzalo_Brown@devin.io', 'Emilio', 'Kovacek', '096731178','Sao Tome and Príncipe, Dejonfurt'),
(14346, 'Berneice.Kozey@lucienne.tv', 'Earline', 'Lubowitz', '096751315','Taiwan, Laurettaport'),
(00258, 'Jeramy@santina.io', 'Kayla', 'Ondricka', '096756665','Belize, Bruenburgh'),
(08559, 'Roslyn_Runte@kaya.info', 'Elva', 'Keebler', '0887513115','Puerto Rico, Harbertown'),
(84058, 'Giovanna.Weissnat@lillian.tv', 'Matt', 'Kilback', '050053144','Switzerland, New Selmer'),
(49731, 'Demond@perry.org', 'Ken', 'Schulist', '0500531955','Puerto Rico, Harbertown'),
(37674, 'Deondre_Ortiz@isai.io', 'Lacey', 'West', '50041944','Aruba, South Vladimir'),
(52079, 'Khalil.Rau@edyth.net', 'Lane', 'Hoppe','093540760','Switzerland, New Selmer'),
(14367, 'Destiny@jeremie.com', 'Ole', 'Wuckert', '092354010','Puerto Rico, Harbertown'),
(82060, 'Bonnie.Steuber@brandi.us', 'Camila', 'Jakubowski', '092354084','Puerto Rico, Harbertown'),
  (47514, 'Rodrick.Schuster@nova.name', 'Eugene', 'Braun', '092420610','Aruba, South Vladimir'),
  (08786, 'Dawson@florencio.name', 'Adrienne', 'Gutkowski', '92420699','Midway Islands, Keelington'),
  (64908, 'Carson@ambrose.name', 'Davion', 'Durgan', '092420100','British Virgin Islands, South Ethelynville'),
  (14617, 'Kenya@van.net', 'Fernando', 'Herzog', '066611110','Switzerland, New Selmer'),
  (47992, 'Maudie_Adams@oswaldo.tv', 'Laury', 'Steuber', '06663866','Venezuela, Jacobsfort'),
  (38858, 'Katlynn.Kutch@yolanda.info', 'Zaria', 'Beatty', '066638610','Qatar, Annemouth'),
  (37882, 'Annetta@nellie.co.uk', 'Emmy', 'Price', '066638681','Anguilla, East Alfonso'),
  (44038, 'Kasandra@delpha.org', 'Sally', 'Krajcik', '99420610','Kiribati, Geoffreymouth'),
  (04308, 'Bailee@isabell.io', 'Conner', 'Ritchie', '050420610','Belize, Bruenburgh');


INSERT INTO Card (IdClient, IdBook, Status)
VALUES
  (1, 1, FALSE),
(1, 4, TRUE),

(2, 1, TRUE),
(2, 2, TRUE),
(2, 3, FALSE),

(3, 8, TRUE),
(3, 7, TRUE),
(3, 4, TRUE),
(3, 5, FALSE),

(6, 8, TRUE),
(6, 3, FALSE),

  (7, 4, FALSE),
  (7, 2, TRUE),

  (19, 5, FALSE),
  (19, 6, FALSE),
  (19, 1, FALSE),

  (17, 9, TRUE);