<?php
$insert = false;
if (isset($_POST['fname'])) {
    // Database credentials
    $server = "localhost";
    $username = "root";
    $password = "";
    $database = "banglaore_trip";

    // Create connection
    $con = new mysqli($server, $username, $password, $database);

    // Check connection
    if ($con->connect_error) {
        die("Connection failed: " . $con->connect_error);
    }

    // Prepare data from POST request
    $name = $con->real_escape_string($_POST['fname']);
    $email = $con->real_escape_string($_POST['email']);
    $gender = $con->real_escape_string($_POST['gender']);
    $contact = $con->real_escape_string($_POST['contact']);
    $dateofbirth = $con->real_escape_string($_POST['dob']);
    $description = $con->real_escape_string($_POST['address']);
    $typeofproof = $con->real_escape_string($_POST['city']);

    // Prepare SQL statement with placeholders
    $sql = "INSERT INTO `trip` (`name`, `email`, `gender`, `contact`, `dob`, `description`, `top`, `dt`) 
            VALUES (?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP(6))";
    
    // Prepare and bind
    $stmt = $con->prepare($sql);
    if ($stmt === false) {
        die("Prepare failed: " . $con->error);
    }
    $stmt->bind_param("sssssss", $name, $email, $gender, $contact, $dateofbirth, $description, $typeofproof);

    // Execute the statement
    if ($stmt->execute()) {
        $insert = true;
        // echo "Record inserted successfully!";
    } else {
        echo "ERROR: " . $stmt->error;
    }

    // Close statement and connection
    $stmt->close();
    $con->close();
}
?>



<html>
    <head>
        <title>Registration Form</title>
        <link rel="stylesheet" href="regis.css">
    </head>
    <body>
        <img class = "bg" src="bangalore.jpg" alt="Banglore"> 
        <div class="container">
            <h1 align="center">Banglore Industry Visit Registration</h1><br>
            <h3><p align="center">Please Enter your details for the confirmation of trip</p></h3><br>
        </div>

        <form class="box" action="Registration.php" method="post">
       
            Full Name:<input type="text" name="fname" placeholder="Enter full name">
            <br><br>
            E-mail id:<input type="email" name="email" placeholder="Enter email id">
            <br><br>
            Gender:
             <input type="text" name="gender">
              
            <br><br>
            Contact: <input type="number" name="contact" placeholder="Enter Contact Number">
            <br><br>
            Date of Birth:<input type="date" name="dob">
            <br><br>
            Description:<br>
           <textarea name="address" rows="5" cols="30" placeholder="Enter your Description"></textarea>
            <br><br>
            Type Of Proof:
            <input type="text" name="city">
            <br><br>
           <br><br>
        <input type="submit" name="submit">
        <input type="reset" name="reset">    
    </form>
    <script src="regis.js"></script>
    
    </body>
</html>
