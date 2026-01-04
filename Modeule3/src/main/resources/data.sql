


--INSERT IGNORE INTO products_table
--(sku, title, price, quantity, created_at, updated_at)
--VALUES
--('SKU1001', 'Wireless Mouse', 799.00, 50, NOW(), NOW()),
--('SKU1002', 'Mechanical Keyboard', 2499.00, 20, NOW(), NOW()),
--('SKU1003', 'USB-C Charger', 1299.50, 100, NOW(), NOW()),
--('SKU1004', 'Bluetooth Headphones', 3999.99, 30, NOW(), NOW()),
--('SKU1005', 'Laptop Stand', 1499.00, 40, NOW(), NOW()),
--('SKU1006', 'Webcam HD', 2299.00, 25, NOW(), NOW()),
--('SKU1007', 'External Hard Drive 1TB', 4599.00, 15, NOW(), NOW()),
--('SKU1008', 'USB Flash Drive 64GB', 699.00, 120, NOW(), NOW()),
--('SKU1009', 'Gaming Mouse Pad', 499.00, 80, NOW(), NOW()),
--('SKU1010', 'Wireless Earbuds', 2999.00, 35, NOW(), NOW()),
--('SKU1011', 'Monitor 24 Inch', 12499.00, 10, NOW(), NOW()),
--('SKU1012', 'HDMI Cable', 399.00, 200, NOW(), NOW()),
--('SKU1013', 'Smartphone Tripod', 899.00, 60, NOW(), NOW()),
--('SKU1014', 'Bluetooth Speaker', 3499.00, 28, NOW(), NOW()),
--('SKU1015', 'Power Bank 20000mAh', 1999.00, 45, NOW(), NOW()),
--('SKU1016', 'USB Hub 4-Port', 1099.00, 55, NOW(), NOW()),
--('SKU1017', 'Wireless Router', 2799.00, 18, NOW(), NOW()),
--('SKU1018', 'Keyboard + Mouse Combo', 1599.00, 32, NOW(), NOW()),
--('SKU1019', 'Noise Cancelling Headphones', 5499.00, 12, NOW(), NOW()),
--('SKU1020', 'Laptop Cooling Pad', 1299.00, 38, NOW(), NOW());




--INSERT INTO patients_table 
--(name, birth_date, email, gender, blood_group) 
--VALUES
--('Amit Sharma', '1995-03-12', 'amit.sharma@gmail.com', 'Male', 'A_POSITIVE'),
--('Priya Verma', '1998-07-21', 'priya.verma@gmail.com', 'Female', 'B_POSITIVE'),
--('Rahul Singh', '1992-11-05', 'rahul.singh@gmail.com', 'Male', 'O_POSITIVE'),
--('Neha Gupta', '1996-01-18', 'neha.gupta@gmail.com', 'Female', 'AB_POSITIVE'),
--('Vikas Mehta', '1990-09-30', 'vikas.mehta@gmail.com', 'Male', 'A_NEGATIVE'),
--('Anjali Patel', '1999-06-14', 'anjali.patel@gmail.com', 'Female', 'B_NEGATIVE'),
--('Rohit Kumar', '1994-04-25', 'rohit.kumar@gmail.com', 'Male', 'O_NEGATIVE'),
--('Sneha Iyer', '1997-12-02', 'sneha.iyer@gmail.com', 'Female', 'AB_NEGATIVE'),
--('Kunal Jain', '1991-08-09', 'kunal.jain@gmail.com', 'Male', 'A_POSITIVE'),
--('Pooja Mishra', '1995-10-17', 'pooja.mishra@gmail.com', 'Female', 'B_POSITIVE'),
--('Arjun Reddy', '1993-02-11', 'arjun.reddy@gmail.com', 'Male', 'O_POSITIVE'),
--('Kavya Nair', '1998-05-28', 'kavya.nair@gmail.com', 'Female', 'AB_POSITIVE'),
--('Suresh Rao', '1989-07-07', 'suresh.rao@gmail.com', 'Male', 'A_NEGATIVE'),
--('Ritu Saxena', '1996-03-03', 'ritu.saxena@gmail.com', 'Female', 'B_NEGATIVE'),
--('Manish Pandey', '1992-01-22', 'manish.pandey@gmail.com', 'Male', 'O_NEGATIVE'),
--('Divya Choudhary', '1999-09-15', 'divya.choudhary@gmail.com', 'Female', 'AB_NEGATIVE'),
--('Nikhil Bansal', '1994-06-01', 'nikhil.bansal@gmail.com', 'Male', 'A_POSITIVE'),
--('Swati Kulkarni', '1997-11-19', 'swati.kulkarni@gmail.com', 'Female', 'B_POSITIVE'),
--('Aakash Yadav', '1991-12-27', 'aakash.yadav@gmail.com', 'Male', 'O_POSITIVE'),
--('Meenal Joshi', '1998-02-08', 'meenal.joshi@gmail.com', 'Female', 'AB_POSITIVE');


INSERT INTO insurance (id, policy_number, provider, valid_until, created_at)
VALUES
(1, 'POL-IND-1001', 'HDFC ERGO', '2026-12-31', NOW(6)),
(2, 'POL-IND-1002', 'ICICI Lombard', '2025-09-15', NOW(6)),
(3, 'POL-IND-1003', 'Star Health', '2027-03-20', NOW(6)),
(4, 'POL-IND-1004', 'Bajaj Allianz', '2026-06-10', NOW(6)),
(5, 'POL-IND-1005', 'Tata AIG', '2025-11-30', NOW(6));

--INSERT INTO patients_table
--(name, email, gender, blood_group, birth_date, created_at)
--VALUES
--('Amit Sharma', 'amit.sharma@gmail.com', 'MALE', 'A_POSITIVE', '1995-04-12', NOW(6)),
--('Priya Verma', 'priya.verma@gmail.com', 'FEMALE', 'B_POSITIVE', '1998-08-25', NOW(6)),
--('Rahul Singh', 'rahul.singh@gmail.com', 'MALE', 'O_POSITIVE', '1992-01-10', NOW(6)),
--('Neha Gupta', 'neha.gupta@gmail.com', 'FEMALE', 'AB_NEGATIVE', '1996-11-03', NOW(6)),
--('Ankit Mishra', 'ankit.mishra@gmail.com', 'MALE', 'O_NEGATIVE', '1990-06-18', NOW(6));




INSERT INTO patients
(name, email, gender, blood_group, birth_date, created_at)
VALUES
('Amit Sharma', 'amit.sharma@gmail.com', 'MALE', 'A_POSITIVE', '1995-04-12', NOW(6)),
('Priya Verma', 'priya.verma@gmail.com', 'FEMALE', 'B_POSITIVE', '1998-08-25', NOW(6)),
('Rahul Singh', 'rahul.singh@gmail.com', 'MALE', 'O_POSITIVE', '1992-01-10', NOW(6)),
('Neha Gupta', 'neha.gupta@gmail.com', 'FEMALE', 'AB_NEGATIVE', '1996-11-03', NOW(6)),
('Ankit Mishra', 'ankit.mishra@gmail.com', 'MALE', 'O_NEGATIVE', '1990-06-18', NOW(6));


INSERT INTO doctor (email, name, specialization) VALUES
('dr.rahul@hospital.com', 'Dr. Rahul Sharma', 'Cardiology'),
('dr.priya@hospital.com', 'Dr. Priya Verma', 'Dermatology'),
('dr.aman@hospital.com', 'Dr. Aman Gupta', 'Orthopedics'),
('dr.neha@hospital.com', 'Dr. Neha Singh', 'Pediatrics'),
('dr.rohit@hospital.com', 'Dr. Rohit Mehta', 'Neurology')
