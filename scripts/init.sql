CREATE TABLE user_type (
    user_type_id int NOT NULL auto_increment,
    user_type varchar(255),
    CONSTRAINT PK_user_type_id PRIMARY KEY (user_type_id)
    );


CREATE TABLE users (
    user_id int NOT NULL auto_increment,
    email varchar(255),
    username varchar(255),
    password varchar(255),
    user_type_id int,
    PRIMARY KEY (user_id),
    CONSTRAINT FK_user_type_id FOREIGN KEY (user_type_id)
    REFERENCES user_type(user_type_id)
);


CREATE TABLE company (
    company_id int NOT NULL auto_increment,
    company_name varchar(255),
    CONSTRAINT PK_company_id PRIMARY KEY (company_id)
    );


CREATE TABLE job_listings (
    job_id int NOT NULL auto_increment,
    job_title varchar(255),
    job_description varchar(255),
    job_location varchar(255),
    benefits varchar(255),
    salary int,
    job_create date,
    job_end date,
    company_id int,
    created_by int,
    PRIMARY KEY (job_id),
    CONSTRAINT FK_company_id FOREIGN KEY (company_id) REFERENCES company(company_id),
    CONSTRAINT FK_created_by FOREIGN KEY (created_by) REFERENCES users(user_id)
);

CREATE TABLE applications (
	application_id int NOT NULL auto_increment,
    user_id int,
    job_id int,
    PRIMARY KEY (application_id),
    CONSTRAINT FK_job_id FOREIGN KEY (job_id) REFERENCES job_listings(job_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE user_skills (
	user_skills_id int NOT NULL auto_increment,
	user_id int,
    skills varchar(255),
    PRIMARY KEY (user_skills_id),
    CONSTRAINT FK_user_id_us FOREIGN KEY (user_id) REFERENCES users(user_id)
);


 CREATE TABLE job_skills (
	job_skills_id int NOT NULL auto_increment,
	job_id int,
    skills varchar(255),
    PRIMARY KEY (job_skills_id),
    CONSTRAINT FK_job_id_js FOREIGN KEY (job_id) REFERENCES job_listings(job_id)
);



INSERT INTO user_type (user_type) VALUES ('JobSeeker');
INSERT INTO user_type (user_type) VALUES ('Jobprovider');
INSERT INTO user_type (user_type) VALUES ('Admin');


INSERT INTO users (email, username, password, user_type_id) VALUES ('Alexa@gmail.com', 'Alexa', 'Alexa',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Drake@gmail.com', 'Drake', 'Drake',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Stewart@gmail.com', 'Stewart', 'Stewart',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Siri@gmail.com', 'Siri', 'Siri',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Rex@gmail.com', 'Rex', 'Rex',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Sam@gmail.com', 'Sam', 'Sam',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Ola@gmail.com', 'Ola', 'Ola',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Kevin@gmail.com', 'Kevin', 'Kevin',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Rosy@gmail.com', 'Rosy', 'Rosy',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Edward@gmail.com', 'Edward', 'Edward',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Jessica@gmail.com', 'Jessica', 'Jessica',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Miles@gmail.com', 'Miles', 'Miles',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Kelly@gmail.com', 'Kelly', 'Kelly',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Peter@gmail.com', 'Peter', 'Peter',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Toby@gmail.com', 'Toby', 'Toby',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('David@gmail.com', 'David', 'David',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('John@gmail.com', 'John', 'John',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Daniel@gmail.com', 'Daniel', 'Daniel',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Bruce@gmail.com', 'Bruce', 'Bruce',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Diana@gmail.com', 'Diana', 'Diana',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Perry@gmail.com', 'Perry', 'Diana',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Liam@gmail.com', 'Liam', 'Liam',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Oliver@gmail.com', 'Oliver', 'Oliver',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Lucas@gmail.com', 'Lucas', 'Lucas',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('William@gmail.com', 'William', 'William',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Elijah@gmail.com', 'Elijah', 'Elijah',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Noah@gmail.com', 'Noah', 'Noah',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Charles@gmail.com', 'Charles', 'Charles',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Paul@gmail.com', 'Paul', 'Paul',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Andrew@gmail.com', 'Andrew', 'Andrew',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Sussan@gmail.com', 'Sussan', 'Sussan',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Betty@gmail.com', 'Betty', 'Betty',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Sarah@gmail.com', 'Sarah', 'Sarah',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Karen@gmail.com', 'Karen', 'Karen',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Mark@gmail.com', 'Mark', 'Mark',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Ashley@gmail.com', 'Ashley', 'Ashley',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('George@gmail.com', 'George', 'George',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Ronald@gmail.com', 'Ronald', 'Ronald',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Jeffery@gmail.com', 'Jeffery', 'Jeffery',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Jacob@gmail.com', 'Jacob', 'Jacob',1);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Ryan@gmail.com', 'Ryan', 'Ryan',1);


INSERT INTO users (email, username, password, user_type_id) VALUES ('Laura@amazon.com', 'Laura', 'Laura',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Carol@capgemini.com', 'Carol', 'Carol',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Rebecca@uber.com', 'Rebecca', 'Rebecca',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Gary@apple.com', 'Gary', 'Gary',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Jason@target.com', 'Jason', 'Jason',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Kenneth@walmart.com', 'Kenneth', 'Kenneth',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Joshua@infosys.com', 'Joshua', 'Joshua',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Donald@deloitte.com', 'Donald', 'Donald',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Katty@nike.com', 'Katty', 'Katty',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Amanda@adidas.com', 'Amanda', 'Amanda',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Sharon@fossil.com', 'Sharon', 'Sharon',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Zion@oats.com', 'Zion', 'Zion',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Donna@meta.com', 'Donna', 'Donna',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Emily@tesla.com', 'Emily', 'Emily',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Kimberley@homedepot.com', 'Kimberley', 'Kimberley',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Gracy@wayfair.com', 'Gracy', 'Gracy',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Amy@mailchimp.com', 'Amy', 'Amy',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Emma@twitter.com', 'Emma', 'Emma',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Helen@cnbc.com', 'Helen', 'Helen',2);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Brenda@orkut.com', 'Brenda', 'Brenda',2);


INSERT INTO users (email, username, password, user_type_id) VALUES ('Yingjie@gmail.com', 'Yingjie', 'Yingjie',3);
INSERT INTO users (email, username, password, user_type_id) VALUES ('Vandana@yahoo.com', 'Vandana', 'Vandana',3);


INSERT INTO company (company_name) VALUES ('Amazon');
INSERT INTO company (company_name) VALUES ('Capgemini');
INSERT INTO company (company_name) VALUES ('Uber');
INSERT INTO company (company_name) VALUES ('Apple');
INSERT INTO company (company_name) VALUES ('Target');
INSERT INTO company (company_name) VALUES ('Walmart');
INSERT INTO company (company_name) VALUES ('Infosys');
INSERT INTO company (company_name) VALUES ('Deloitte');
INSERT INTO company (company_name) VALUES ('Nike');
INSERT INTO company (company_name) VALUES ('Adidas');
INSERT INTO company (company_name) VALUES ('Fossil');
INSERT INTO company (company_name) VALUES ('Oats');
INSERT INTO company (company_name) VALUES ('Meta');
INSERT INTO company (company_name) VALUES ('Tesla');
INSERT INTO company (company_name) VALUES ('Homedepot');
INSERT INTO company (company_name) VALUES ('Wayfair');
INSERT INTO company (company_name) VALUES ('Mailchimp');
INSERT INTO company (company_name) VALUES ('Twitter');
INSERT INTO company (company_name) VALUES ('CNBC');
INSERT INTO company (company_name) VALUES ('Orkut');
INSERT INTO company (company_name) VALUES ('Yahoo');

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Software Engineer', 'Write, debug, maintain, and test software that instructs a computer to accomplish certain tasks', 'SanJose', 'Working collaboratively and individually', 70000, '2022-11-06', '2023-06-01', 1, 42);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Data Analyst', 'Work with data to help their organizations make better business decisions', 'Austin', 'Hybrid', 900000, '2022-12-03', '2023-02-05', 3, 48);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Full Stack Developer', 'Design, develop and maintain fully-fledged functioning platforms with databases or servers', 'NewYork', 'Remote', 1200000, '2022-10-03', '2023-05-08', 20, 43);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Network Development Engineer', 'Create and implement changes on the network', 'Seattle', 'Remote', 80000, '2022-11-24', '2023-03-23', 15, 59);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Data Scientist', 'Incorporating a variety of statistical and machine learning techniques', 'Houston', 'Hybrid', 60000, '2022-10-20', '2023-02-20', 16, 54);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Quality Engineer', 'Designing test plans, scenarios, scripts, and procedures', 'New Jersey', 'Remote', 68000, '2022-10-24', '2023-04-15', 17, 51);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('System Integration Engineer', 'Plan, design, and implement the integration process', 'Savannah', 'Paid time Off', 45000, '2022-11-24', '2023-02-14', 2, 58);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Business Analyst', 'Elicits, analyzes, specifies, and validates the business needs of stakeholders', 'Atlanta', 'Health Insurance', 50000, '2022-12-02', '2023-01-10', 11, 52);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Project Manager', 'Planning and developing the project idea', 'San Marcos', 'Remote', 60000, '2022-11-02', '2023-03-12', 18, 61);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Backend Developer', 'Write code and tests, build prototypes, resolve issues, and profile and analyze bottlenecks ', 'Virginia', 'Hybrid', 80000, '2022-10-20', '2023-06-22', 6, 56);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Frontend Developer', 'Specialize in website design', 'Maryland', 'Health Insurance', 75000, '2022-09-11', '2023-08-27', 8, 49);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Power BI developer', 'Design and develop BI reports and for providing insights to improve decision-making', 'Dallas', 'Remote', 90000, '2022-11-12', '2023-02-28', 13, 55);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Python Developer', 'Build and deploy programs', 'Utah', 'Hybrid', 120000, '2022-10-01', '2023-04-20', 5, 53);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Salesforce Developer', 'Design and build high-performance, reusable, and reliable Apex code', 'Fresno', 'Remote', 145000, '2022-12-04', '2023-01-12', 12, 57);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Intelligence Analyst', 'Develop methodologies to improve data analysis', 'Michigan', 'Hybrid', 110000, '2022-09-13', '2023-01-02', 10, 45);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Cybersecurity Engineer', 'Performing technical security assessments, design reviews, and code audits', 'Delaware', 'Health Insurance', 69000, '2022-10-10', '2023-01-26', 14, 46);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Devops Engineer', 'Deploy updates and fixes, and provide Level 2 technical support', 'Chicago', 'Remote', 85000, '2022-11-24', '2023-03-30', 7, 47);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Service Manager', 'Managing service level agreements with customers and external service providers', 'Boston', 'Paid leave', 100000, '2022-10-19', '2023-04-05', 4, 50);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('Quantum Software', 'Optimizing the control of the all-important quantum processors', 'Arizona', 'Remote', 77000, '2022-12-09', '2023-05-16', 19, 60);

INSERT INTO  job_listings (job_title, job_description, job_location, benefits, salary, job_create, job_end, company_id, created_by) VALUES
('System Engineer', 'Managing and monitoring all installed systems and infrastructure', 'San Diego', 'Hybrid', 65000, '2022-11-18', '2023-08-29', 9, 44);

INSERT INTO job_skills (job_id, skills) VALUES (1, 'Java');
INSERT INTO job_skills (job_id, skills) VALUES (1, 'DB');
INSERT INTO job_skills (job_id, skills) VALUES (2, 'C++');
INSERT INTO job_skills (job_id, skills) VALUES (2, 'Python');
INSERT INTO job_skills (job_id, skills) VALUES (3, 'Scrum');
INSERT INTO job_skills (job_id, skills) VALUES (3, 'DB');
INSERT INTO job_skills (job_id, skills) VALUES (4, 'Java');
INSERT INTO job_skills (job_id, skills) VALUES (4, 'HTML');
INSERT INTO job_skills (job_id, skills) VALUES (5, 'Oracle');
INSERT INTO job_skills (job_id, skills) VALUES (5, 'Java');
INSERT INTO job_skills (job_id, skills) VALUES (6, 'Python');
INSERT INTO job_skills (job_id, skills) VALUES (6, 'C');
INSERT INTO job_skills (job_id, skills) VALUES (7, '.Net');
INSERT INTO job_skills (job_id, skills) VALUES (7, 'MongoDB');
INSERT INTO job_skills (job_id, skills) VALUES (8, 'Agile');
INSERT INTO job_skills (job_id, skills) VALUES (8, 'Java');
INSERT INTO job_skills (job_id, skills) VALUES (9, 'C++');
INSERT INTO job_skills (job_id, skills) VALUES (9, 'Posgres');
INSERT INTO job_skills (job_id, skills) VALUES (10, 'R');
INSERT INTO job_skills (job_id, skills) VALUES (10, 'React');
INSERT INTO job_skills (job_id, skills) VALUES (11, 'JavaScript');
INSERT INTO job_skills (job_id, skills) VALUES (11, 'DB');
INSERT INTO job_skills (job_id, skills) VALUES (12, 'Angular');
INSERT INTO job_skills (job_id, skills) VALUES (12, 'Salesforce');
INSERT INTO job_skills (job_id, skills) VALUES (13, 'Database');
INSERT INTO job_skills (job_id, skills) VALUES (13, 'C++');
INSERT INTO job_skills (job_id, skills) VALUES (14, 'Workday');
INSERT INTO job_skills (job_id, skills) VALUES (14, 'Javascript');
INSERT INTO job_skills (job_id, skills) VALUES (15, 'MongoDB');
INSERT INTO job_skills (job_id, skills) VALUES (15, 'C++');
INSERT INTO job_skills (job_id, skills) VALUES (16, 'Angular');
INSERT INTO job_skills (job_id, skills) VALUES (16, 'Python');
INSERT INTO job_skills (job_id, skills) VALUES (17, 'Java');
INSERT INTO job_skills (job_id, skills) VALUES (17, 'RDBMS');
INSERT INTO job_skills (job_id, skills) VALUES (18, 'Java');
INSERT INTO job_skills (job_id, skills) VALUES (18, 'Python');
INSERT INTO job_skills (job_id, skills) VALUES (19, '.Net');
INSERT INTO job_skills (job_id, skills) VALUES (19, 'R');
INSERT INTO job_skills (job_id, skills) VALUES (20, 'SQL');
INSERT INTO job_skills (job_id, skills) VALUES (20, 'Python');

INSERT INTO user_skills (user_id, skills) VALUES (1, 'C++');
INSERT INTO user_skills (user_id, skills) VALUES (2, 'AI');
INSERT INTO user_skills (user_id, skills) VALUES (2, 'Java');
INSERT INTO user_skills (user_id, skills) VALUES (3, 'Python');
INSERT INTO user_skills (user_id, skills) VALUES (3, 'R');
INSERT INTO user_skills (user_id, skills) VALUES (4, '.Net');
INSERT INTO user_skills (user_id, skills) VALUES (5, 'Oracle');
INSERT INTO user_skills (user_id, skills) VALUES (6, 'Python');
INSERT INTO user_skills (user_id, skills) VALUES (7, 'MongoDB');
INSERT INTO user_skills (user_id, skills) VALUES (8, 'Agile');
INSERT INTO user_skills (user_id, skills) VALUES (8, 'Java');
INSERT INTO user_skills (user_id, skills) VALUES (9, 'Posgres');
INSERT INTO user_skills (user_id, skills) VALUES (10, 'R');
INSERT INTO user_skills (user_id, skills) VALUES (10, 'React');
INSERT INTO user_skills (user_id, skills) VALUES (11, 'JavaScript');
INSERT INTO user_skills (user_id, skills) VALUES (12, 'Angular');
INSERT INTO user_skills (user_id, skills) VALUES (13, 'C++');
INSERT INTO user_skills (user_id, skills) VALUES (14, 'Salesforce');
INSERT INTO user_skills (user_id, skills) VALUES (15, 'C++');
INSERT INTO user_skills (user_id, skills) VALUES (16, 'Angular');
INSERT INTO user_skills (user_id, skills) VALUES (17, 'Java');
INSERT INTO user_skills (user_id, skills) VALUES (17, 'C');
INSERT INTO user_skills (user_id, skills) VALUES (18, 'Python');
INSERT INTO user_skills (user_id, skills) VALUES (19, 'R');
INSERT INTO user_skills (user_id, skills) VALUES (20, 'C++');


 INSERT INTO applications (user_id, job_id) VALUES (1, 1);
 INSERT INTO applications (user_id, job_id) VALUES (1, 2);
 INSERT INTO applications (user_id, job_id) VALUES (4, 3);
 INSERT INTO applications (user_id, job_id) VALUES (3, 6);
 INSERT INTO applications (user_id, job_id) VALUES (1, 5);
 INSERT INTO applications (user_id, job_id) VALUES (2, 8);
 INSERT INTO applications (user_id, job_id) VALUES (4, 4);
 INSERT INTO applications (user_id, job_id) VALUES (8, 9);
 INSERT INTO applications (user_id, job_id) VALUES (9, 6);
 INSERT INTO applications (user_id, job_id) VALUES (7, 1);
 INSERT INTO applications (user_id, job_id) VALUES (5, 3);
 INSERT INTO applications (user_id, job_id) VALUES (6, 1);
 INSERT INTO applications (user_id, job_id) VALUES (8, 1);
 INSERT INTO applications (user_id, job_id) VALUES (3, 2);
 INSERT INTO applications (user_id, job_id) VALUES (9, 3);
 INSERT INTO applications (user_id, job_id) VALUES (2, 6);
 INSERT INTO applications (user_id, job_id) VALUES (7, 5);
 INSERT INTO applications (user_id, job_id) VALUES (5, 8);
 INSERT INTO applications (user_id, job_id) VALUES (4, 4);
 INSERT INTO applications (user_id, job_id) VALUES (1, 9);
 INSERT INTO applications (user_id, job_id) VALUES (7, 3);
 INSERT INTO applications (user_id, job_id) VALUES (8, 2);