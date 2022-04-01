

<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8; width=device-width" />
    <title>Maxtek Personal Finance Managment</title>
    <link href="css/aboutstyle.css" rel="stylesheet" type="text/css" />

    <!-- various style sheets added -->
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/navbar.css"/>
    <!-- font added here -->
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;700&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="css/aboutus2.css"/>

</head>
<script defer src="js/navbar.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<body>
<br></br>
<!-- Navagtion section -->
<div class="stick">
    <!-- putting it in a container and allowing it to flex display so display is correct -->
    <div style="display:flex;">
        <!-- giving the hamburgers an id to access for click events -->
        <div class="hamburger" id="hamburger">
            <div class="bar1"></div>
            <div class="bar2"></div>
            <div class="bar3"></div>
        </div>
        <!-- giving logo an id for other hover effects -->
        <div id="lth" class="logo" style="width: fit-content;
        margin: auto;
        display: flex;">
            <img alt="Logo" src="./Images-site/Logo_1.png" width="150px" onmouseover="bigImg(this)"
                 onmouseout="normalImg(this)">
        </div>
    </div>

    <!-- importing the logo to be placed at the top right inline with the navbar -->
    <div class="navbar--middle" id="navbar--middle">

        <nav style="padding: 0;
        display: flex;
        flex-wrap: nowrap;
        justify-content: center;
        align-items: center;">
            <ul style="display:inline-flex; list-style-type:none; align-items:center;">

                <!-- navbar is listed unordered in a tags and linking appropriately -->
                <li><a class="current" href="home.jsp">Home</a></li>
                <li><a href="about.jsp">About Us</a></li>
                <li class="checker"><a>Apps</a>
                    <!-- dropdown is created -->
                    <ul class="dropdown">

                        <li class="dropdown-item"><a href="services.jsp">Services</a></li>
                        <li class="dropdown-item"><a href="myaccount.jsp"> My Account</a></li>

                    </ul>
                </li>
                <li><a href="newsblog.jsp">News and Blogs</a></li>
                <li><a href="contact.jsp">Contact Us</a></li>
                <li><a href="LogoutServlet" class="register-btn">Logout</a></li>
            </ul>
        </nav>
    </div>
</div>
<br>
<br>

<!-- Logo for About Us -->


<div class="aboutus_logos">
    <h1>About US</h1>
</div>

<br>
<br>


<!-- Main About Us Image-->
<div class="aboutuus_banner">
    <img src="./Images-site/banner.jpg">
</div>

<br>
<br>

<!-- About Us text paragraph -->
<div class="aboutus_text">

    <p><b>DCU Bank is an online fintech platform that was established in 2013 in Ireland by Franklin Leroy. DCU Bank
        aims
        to be the number 1 financial tool for everyones day to day use. Be it saving, investing or day to day banking
            such as payments and bank transfers. Since its inception DCU Bank has achieved over 50,000 daily users and has done over $2 billion in volume worth
        of daily transfers. In 2021 we had a revenue of $300m and are constantly using our funds to help increase the user
        experience each user gets from our platform.
        <br>
        <br>
        Start banking with us today!
        </b></p>
</div>

<br>
<br>
<br>

<div class="aboutus_logos">
    <h1> The Team </h1>
</div>>

<br>
<br>
<br>
<section class="team_section" style=" background-image: linear-gradient(120deg, hsl(234, 70%, 51%),hsl(0, 0%, 57%)">
    <div>
        <br>
        <img src="./Images-site/founder1.jpg" style="height:350px; padding:5px"/>


        <p style="color: white; text-align: center;">
            <br>
            <b>Franklin Leroy (CEO) </b>

        </p>

        <br>
    </div>
    <div>
        <img src="./Images-site/founder2.jpg" style=" height:350px; padding:10px"/>

        <p style=" color: white; text-align: center;">
            <br>
            <b>Theodore Michael (COO) </b>
        </p>
        <br>

    </div>

</section>

<br>
<br>
<br>

<div class="footer">
    <br>
    <h1 style="color: hsl(234, 70%, 51%)">Sign Up For Updates</h1>
    <br>
    <!-- Footer section
        Has email input and a button to submit-->
    <form action="NewsletterServlet" id="form">
        <label for="emailft" style="font-size: medium; color:">Enter your email:</label>
        <input type="email" id="emailft" name="emailft" class="email_input">
        <input type="submit" class="footer_button">
    </form>
    <div class="error_success"></div>
    <br>
</div>

</body>
</html>