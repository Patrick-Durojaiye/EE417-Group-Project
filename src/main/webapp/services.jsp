
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8; width=device-width" />
    <title>DCU Bank</title>
    <link href="css/servicesstyle.css" rel="stylesheet" type="text/css" />
    <!-- various style sheets added -->
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/navbar.css"/>
    <!-- font added here -->
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;700&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="css/formstyle.css"/>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script defer src="js/navbar.js"></script>

<body>
<br>
<!-- forming the hamburger menu -->
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
            <img src="./Images-site/Logo_1.png" alt="logo" width="150px" onmouseover="bigImg(this)"
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
<br>
<br>
<section class="log-form" style=" background-image: linear-gradient(120deg, hsl(234, 70%, 51%),hsl(0, 0%, 57%)">
    <!-- Form to process transferring funds-->
    <form action="TransferRequestServlet" method="post" class="form_section" id="form">
        <div class="form-box">

            <div class="titles">
                <!-- inline css used here -->
                <h4 style="color:hsl(234, 70%, 51%)">Make a Transfer</h4>
            </div>

            <div class="form-field">
        <div class= "input-box">
        <p style="font-size:medium; color: black"><b>Your Name:</b></p>        
        
        <input type="text" id="name" name="name" class="inputs">
        <div class="error"></div>
                </div>
        <br>
        <br>
                <div class= "input-box">
        <p style="font-size:medium; color: black"><b>Account Number You Are Transferring To:</b></p>
        
        <input type="number" id="Account_No" name="Account_No" class="inputs">
        <div class="error"></div>
                </div>
        <br>
        <br>

                <div class= "input-box">
        <p style="font-size:medium; color: black"><b></>Choose how much do you want to Transfer ($):</b>
        </p>
        <input type="number" name="price" id="price" min="10" max="1000" step="10" value="10"
               >
        <output style="color: black" class="price-output" for="price" id="amountout"></output>
        <script>const price = document.querySelector('#price');
        const output = document.querySelector('.price-output');
        output.textContent = price.value;
        price.addEventListener('input', function () {
            output.textContent = price.value;
        });
        </script>
        <div class="error"></div>
                </div>
        <br>
        <br>
                <div class="button-login">
        <button class="button_input" type="submit"> Send </button>
                </div>
        </div>
        </div>
    </form>
</section>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<section class="log-form" style=" background-image: linear-gradient(120deg, hsl(234, 70%, 51%),hsl(0, 0%, 57%)">

    <!-- Form application to apply for a loan -->
    <form action="LoanServlet" method="post" class="form_section" id="form1">
        <div class="form-box">

            <div class="titles">
                <!-- inline css used here -->
                <h4 style="color:hsl(234, 70%, 51%)"> Loan Application </h4>
            </div>

            <div class="form-field">
                <div class= "input-box">
        <p style="font-size:medium; color: black"><b>Account Number:</b></p>
        
        <input type="number" id="Account_No1" name="Account_No1" class="inputs">
        <div class="error1"></div>
                </div>
        <br>
        <br>
        <div class= "input-box">
        <p style="font-size:medium; color: black"><b>Name:</b></p>
        
        <input type="text" id="name1" name="name1" class="inputs">
        <div class="error1"></div>
                </div>
        <br>
        <br>

        <div class= "input-box">
        <p style="font-size:medium; color: black"><b>Email:</b></p>
        
        <input type="email" id="email1" name="email1" class="inputs">
        <div class="error1"></div>
                </div>
        <br>
        <br>

        <div class= "input-box">
        <p style="font-size:medium; color: black"><b>How much do you want to burrow ($):</b></p>
       
       
        <input type="number" name="amount" id="amount" min="20" max="1000" step="10" value="20"
               >
        <output style="color: black" class="amount-output" for="amount" id="amountout1"> </output>
        <script>const amount = document.querySelector('#amount');
        const output1 = document.querySelector('.amount-output');
        output1.textContent = amount.value;
        amount.addEventListener('input', function () {
            output1.textContent = amount.value;
        });
        </script>
        <div class="error1"></div>
                </div>
        <br>
        <br>
                <div class="button-login">
        <button class="button_input" type="submit"> Apply </button>
                </div>
        </div>
    </div>
    </form>
</section>



<br>


</body>