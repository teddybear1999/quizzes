--liquibase formatted sql
--changeset teddy-bear1999:8

INSERT INTO quiz (description, type, min_score, created)
VALUES ('General knowledge quiz about various topics.', 'OTHER', 50, NOW()),
       ('Test your math skills with this challenging quiz.', 'MATH', 60, NOW()),
       ('Explore the wonders of science with this quiz.', 'SCIENCE', 65, NOW()),
       ('Dive deep into the world of literature with this quiz.', 'LITERATURE', 70, NOW()),
       ('How well do you know your music? Find out with this quiz.', 'MUSIC', 55, NOW()),
       ('Discover the world of art with this enlightening quiz.', 'ART', 60, NOW()),
       ('Are you a sports enthusiast? Test your knowledge here.', 'SPORTS', 75, NOW()),
       ('Travel the world with this geography quiz.', 'GEOGRAPHY', 80, NOW()),
       ('Are you a movie buff? Prove it with this quiz.', 'MOVIES', 85, NOW()),
       ('How well do you know your favorite TV shows? Find out now.', 'TV_SHOWS', 90, NOW()),
       ('Test your IT knowledge with this comprehensive quiz.', 'IT', 95, NOW()),
       ('Travel back in time with this historical quiz.', 'HISTORICAL', 100, NOW()),
       ('Another general knowledge quiz about various topics.', 'OTHER', 50, NOW()),
       ('Another challenging math quiz to test your skills.', 'MATH', 60, NOW()),
       ('Another science quiz to explore the wonders of the universe.', 'SCIENCE', 65, NOW());

-- Questions for the Literature quiz
INSERT INTO quiz_question (quiz_id, content, option_a, option_b, option_c, option_d, answer)
VALUES (16, 'Who wrote "Romeo and Juliet"?', 'Charles Dickens', 'Jane Austen', 'William Shakespeare', 'George Orwell',
        3),
       (16, 'In which novel would you find the character Frodo Baggins?', 'Harry Potter', 'The Chronicles of Narnia',
        'The Lord of the Rings', 'A Song of Ice and Fire', 3),
       (16, 'Which novel is set during the French Revolution?', 'Pride and Prejudice', 'A Tale of Two Cities',
        'Moby Dick', 'The Great Gatsby', 2),
       (16, 'Who wrote "To Kill a Mockingbird"?', 'Harper Lee', 'Sylvia Plath', 'Virginia Woolf', 'Emily Dickinson', 1),
       (16, 'Which of these is not a play by William Shakespeare?', 'Macbeth', 'Othello', 'The Old Man and the Sea',
        'Hamlet', 3),

-- Questions for the Music quiz
       (17, 'Which instrument is known as the "king of instruments"?', 'Piano', 'Violin', 'Organ', 'Guitar', 3),
       (17, 'Who composed the "Moonlight Sonata"?', 'Johann Sebastian Bach', 'Wolfgang Amadeus Mozart',
        'Franz Schubert', 'Ludwig van Beethoven', 4),
       (17, 'Which of these bands is known for "Stairway to Heaven"?', 'The Beatles', 'Pink Floyd', 'Led Zeppelin',
        'The Rolling Stones', 3),
       (17, 'Who is known as the "Queen of Pop"?', 'Beyoncé', 'Madonna', 'Lady Gaga', 'Whitney Houston', 2),
       (17, 'Which of these is not a musical note?', 'Do', 'Re', 'Ti', 'Zo', 4),

-- Questions for the Art quiz
       (18, 'Who painted the "Mona Lisa"?', 'Vincent van Gogh', 'Leonardo da Vinci', 'Pablo Picasso', 'Michelangelo',
        2),
       (18, 'Which of these is not a primary color?', 'Red', 'Blue', 'Yellow', 'Green', 4),
       (18, 'What type of art is three-dimensional?', 'Mural', 'Sculpture', 'Sketch', 'Watercolor', 2),
       (18, 'Who painted the ceiling of the Sistine Chapel?', 'Raphael', 'Donatello', 'Michelangelo', 'Caravaggio', 3),
       (18, 'Which movement is Salvador Dali associated with?', 'Impressionism', 'Cubism', 'Surrealism', 'Realism', 3),

-- Questions for the Sports quiz
       (19, 'Which sport is played in the Wimbledon Championship?', 'Cricket', 'Football', 'Tennis', 'Rugby', 3),
       (19, 'In which sport would you perform a slam dunk?', 'Baseball', 'Volleyball', 'Basketball', 'Badminton', 3),
       (19, 'How many players are there in a standard soccer team?', '9', '10', '11', '12', 3),
       (19, 'Which country hosted the 2016 Summer Olympics?', 'Russia', 'Brazil', 'China', 'Australia', 2),
       (19, 'In which sport is the term "hole-in-one" used?', 'Tennis', 'Golf', 'Badminton', 'Boxing', 2),

-- Questions for the Geography quiz
       (20, 'Which is the largest continent by land area?', 'Africa', 'Asia', 'Europe', 'Australia', 2),
       (20, 'Which river is the longest in the world?', 'Amazon', 'Nile', 'Mississippi', 'Thames', 2),
       (20, 'Which country is known for its pyramids?', 'India', 'Mexico', 'Egypt', 'Greece', 3),
       (20, 'Which of these countries is not in Europe?', 'Spain', 'Brazil', 'Germany', 'France', 2),
       (20, 'Which mountain is the highest in the world?', 'Kilimanjaro', 'Everest', 'K2', 'Matterhorn', 2),

-- Questions for the Movies quiz
       (21, 'Who directed "Jurassic Park"?', 'Steven Spielberg', 'James Cameron', 'George Lucas', 'Tim Burton', 1),
       (21, 'Which movie features a character named Simba?', 'The Lion King', 'Aladdin', 'Toy Story', 'Frozen', 1),
       (21, 'Which of these movies is not based on a Marvel comic?', 'Iron Man', 'Thor', 'The Dark Knight',
        'The Avengers', 3),
       (21, 'Who played Jack Dawson in "Titanic"?', 'Brad Pitt', 'Tom Cruise', 'Leonardo DiCaprio', 'Johnny Depp', 3),
       (21, 'Which movie features a giant ape named King Kong?', 'Godzilla', 'Jurassic Park', 'King Kong',
        'Planet of the Apes', 3),

       (16, 'Who wrote "Romeo and Juliet"?', 'Charles Dickens', 'Jane Austen', 'William Shakespeare', 'George Orwell',
        3),
       (16, 'In which novel would you find the character Frodo Baggins?', 'Harry Potter', 'The Chronicles of Narnia',
        'The Lord of the Rings', 'A Song of Ice and Fire', 3),
       (16, 'Which novel is set during the French Revolution?', 'Pride and Prejudice', 'A Tale of Two Cities',
        'Moby Dick', 'The Great Gatsby', 2),
       (16, 'Who wrote "To Kill a Mockingbird"?', 'Harper Lee', 'Sylvia Plath', 'Virginia Woolf', 'Emily Dickinson', 1),
       (16, 'Which of these is not a play by William Shakespeare?', 'Macbeth', 'Othello', 'The Old Man and the Sea',
        'Hamlet', 3),

-- Questions for the Music quiz
       (17, 'Which instrument is known as the "king of instruments"?', 'Piano', 'Violin', 'Organ', 'Guitar', 3),
       (17, 'Who composed the "Moonlight Sonata"?', 'Johann Sebastian Bach', 'Wolfgang Amadeus Mozart',
        'Franz Schubert', 'Ludwig van Beethoven', 4),
       (17, 'Which of these bands is known for "Stairway to Heaven"?', 'The Beatles', 'Pink Floyd', 'Led Zeppelin',
        'The Rolling Stones', 3),
       (17, 'Who is known as the "Queen of Pop"?', 'Beyoncé', 'Madonna', 'Lady Gaga', 'Whitney Houston', 2),
       (17, 'Which of these is not a musical note?', 'Do', 'Re', 'Ti', 'Zo', 4),

-- Questions for the Art quiz
       (18, 'Who painted the "Mona Lisa"?', 'Vincent van Gogh', 'Leonardo da Vinci', 'Pablo Picasso', 'Michelangelo',
        2),
       (18, 'Which of these is not a primary color?', 'Red', 'Blue', 'Yellow', 'Green', 4),
       (18, 'What type of art is three-dimensional?', 'Mural', 'Sculpture', 'Sketch', 'Watercolor', 2),
       (18, 'Who painted the ceiling of the Sistine Chapel?', 'Raphael', 'Donatello', 'Michelangelo', 'Caravaggio', 3),
       (18, 'Which movement is Salvador Dali associated with?', 'Impressionism', 'Cubism', 'Surrealism', 'Realism', 3),

-- Questions for the Sports quiz
       (19, 'Which sport is played in the Wimbledon Championship?', 'Cricket', 'Football', 'Tennis', 'Rugby', 3),
       (19, 'In which sport would you perform a slam dunk?', 'Baseball', 'Volleyball', 'Basketball', 'Badminton', 3),
       (19, 'How many players are there in a standard soccer team?', '9', '10', '11', '12', 3),
       (19, 'Which country hosted the 2016 Summer Olympics?', 'Russia', 'Brazil', 'China', 'Australia', 2),
       (19, 'In which sport is the term "hole-in-one" used?', 'Tennis', 'Golf', 'Badminton', 'Boxing', 2),

-- Questions for the Geography quiz
       (20, 'Which is the largest continent by land area?', 'Africa', 'Asia', 'Europe', 'Australia', 2),
       (20, 'Which river is the longest in the world?', 'Amazon', 'Nile', 'Mississippi', 'Thames', 2),
       (20, 'Which country is known for its pyramids?', 'India', 'Mexico', 'Egypt', 'Greece', 3),
       (20, 'Which of these countries is not in Europe?', 'Spain', 'Brazil', 'Germany', 'France', 2),
       (20, 'Which mountain is the highest in the world?', 'Kilimanjaro', 'Everest', 'K2', 'Matterhorn', 2),

-- Questions for the Movies quiz
       (21, 'Who directed "Jurassic Park"?', 'Steven Spielberg', 'James Cameron', 'George Lucas', 'Tim Burton', 1),
       (21, 'Which movie features a character named Simba?', 'The Lion King', 'Aladdin', 'Toy Story', 'Frozen', 1),
       (21, 'Which of these movies is not based on a Marvel comic?', 'Iron Man', 'Thor', 'The Dark Knight',
        'The Avengers', 3),
       (21, 'Who played Jack Dawson in "Titanic"?', 'Brad Pitt', 'Tom Cruise', 'Leonardo DiCaprio', 'Johnny Depp', 3),
       (21, 'Which movie features a giant ape named King Kong?', 'Godzilla', 'Jurassic Park', 'King Kong',
        'Planet of the Apes', 3),

-- For the TV Shows Quiz
       (22, "Who played the character Walter White in the TV show 'Breaking Bad'?", "Bryan Cranston", "Aaron Paul",
        "Bob Odenkirk", "Dean Norris", 1),
       (22, "Which TV show is set in the fictional town of Pawnee, Indiana?", "Friends", "The Office",
        "Parks and Recreation", "Brooklyn Nine-Nine", 3),
       (22, "Who is the mother in the show 'How I Met Your Mother'?", "Robin", "Lily", "Tracy", "Victoria", 3),
       (22, "In 'Game of Thrones', who says the line 'A Lannister always pays his debts'?", "Tyrion Lannister",
        "Ned Stark", "Arya Stark", "Daenerys Targaryen", 1),
       (22, "Which show features the character Sheldon Cooper?", "Friends", "The Big Bang Theory", "Breaking Bad",
        "Stranger Things", 2),
       (22, "What's the name of the coffee shop in 'Friends'?", "Café Grumpy", "Central Perk", "MacLaren's Pub",
        "Monk's Café", 2),
       (22, "In 'Stranger Things', which character gets trapped in the Upside Down?", "Will", "Mike", "Dustin", "Lucas",
        1),
       (22, "What's the name of the bar in 'How I Met Your Mother'?", "Paddy's Pub", "Cheers", "Central Perk",
        "MacLaren's Pub", 4),

-- For the IT Quiz
       (23, "What does CPU stand for?", "Central Program Unit", "Computer Primary Unit", "Central Processor Unit",
        "Central Processing Unit", 4),
       (23, "In programming, 'Python' is a ...?", "Reptile", "Game", "Programming Language", "Software", 3),
       (23, "Which company developed Windows?", "Apple", "Microsoft", "IBM", "Google", 2),
       (23, "HTML is used to create...", "Operating Systems", "Games", "Web Pages", "Databases", 3),
       (23, "Which of these is not an operating system?", "Ubuntu", "Apache", "Linux", "Android", 2),
       (23, "Which is a database management system?", "Java", "Python", "Excel", "MySQL", 4),
       (23, "What does RAM stand for?", "Read Area Memory", "Random Access Memory", "Ready Artificial Memory",
        "Random Area Memory", 2),
       (23, "Which language is used for web apps?", "PHP", "Python", "C#", "Java", 1),

-- For the Historical Quiz
       (24, "Who was the first president of the United States?", "George Washington", "Thomas Jefferson",
        "Abraham Lincoln", "Benjamin Franklin", 1),
       (24, "In which year did World War II end?", "1940", "1945", "1950", "1955", 2),
       (24, "Where was Napoleon Bonaparte exiled to?", "Australia", "Alcatraz", "Elba", "St. Helena", 4),
       (24, "Who wrote the 'I Have a Dream' speech?", "Martin Luther King Jr.", "Barack Obama", "Malcolm X",
        "Nelson Mandela", 1),
       (24, "What was the main topic of 'The Magna Carta'?", "Abolition of Slavery", "Women's Rights",
        "Limitation of King's Power", "Child Rights", 3),
       (24, "The Renaissance started in which country?", "Germany", "Spain", "Italy", "France", 3),
       (24, "Who was known as the 'Maid of Orléans'?", "Joan of Arc", "Mary Magdalene", "Marie Antoinette",
        "Catherine the Great", 1),
       (24, "In which century was the American Revolution?", "16th Century", "17th Century", "18th Century",
        "19th Century", 3),

-- For the Other General Knowledge Quiz
       (25, "Which planet is known as the 'Red Planet'?", "Mars", "Venus", "Saturn", "Jupiter", 1),
       (25, "Which river is the longest in the world?", "Nile", "Amazon", "Mississippi", "Yangtze", 2),
       (25, "Which sport is played at Wimbledon?", "Football", "Cricket", "Tennis", "Badminton", 3),
       (25, "In which country is the Great Pyramid of Giza?", "Greece", "Egypt", "Mexico", "Peru", 2),
       (25, "How many bones are in the human body?", "206", "210", "195", "187", 1),
       (25, "Which element has the chemical symbol 'Au'?", "Silver", "Argon", "Gold", "Aurora", 3),
       (25, "Which animal is known as the 'King of the Jungle'?", "Tiger", "Elephant", "Lion", "Cheetah", 3),
       (25, "In which continent is the Sahara Desert located?", "Asia", "Australia", "Africa", "South America", 3),

-- For the Math Quiz
       (26, "What is the square root of 144?", "10", "12", "14", "16", 2),
       (26, "If a triangle has one angle of 90 degrees, what is it called?", "Obtuse", "Equilateral", "Right",
        "Isosceles", 3),
       (26, "What is \( \pi \) rounded to two decimal places?", "3.14", "3.15", "3.16", "3.12", 1),
       (26, "What is the smallest prime number?", "0", "1", "2", "3", 3),
       (26, "What is 7 times 8?", "54", "56", "58", "60", 2),
       (26, "How many sides does a decagon have?", "10", "8", "12", "9", 1),
       (26, "If a shop gives a 10% discount on a $100 item, how much will it cost?", "$90", "$80", "$85", "$95", 1),
       (26, "What comes next in the series: 2, 4, 8, 16, ...?", "32", "20", "18", "24", 1),

-- For the Science Quiz
       (27, "What is the chemical symbol for water?", "H2O", "CO2", "NaCl", "O2", 1),
       (27, "Which planet is known for its rings?", "Mars", "Jupiter", "Venus", "Saturn", 4),
       (27, "What part of the cell contains the DNA?", "Nucleus", "Mitochondria", "Ribosome", "Lysosome", 1),
       (27, "What is the process by which plants make their food?", "Digestion", "Respiration", "Photosynthesis",
        "Osmosis", 3),
       (27, "What is the largest mammal?", "Elephant", "Blue Whale", "Giraffe", "Hippopotamus", 2),
       (27, "Which of the following is not a gas at room temperature?", "Helium", "Oxygen", "Mercury", "Nitrogen", 3),
       (27, "Which element is represented by the letter 'K'?", "Potassium", "Krypton", "Kallium", "Kilium", 1),
       (27, "What force pulls objects toward the center of the Earth?", "Friction", "Magnetism", "Centrifugal",
        "Gravity", 4);
