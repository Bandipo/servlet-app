<%--
  Created by IntelliJ IDEA.
  User: taiye.bandipo
  Date: 30/10/2022
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        #firstname, #lastname, #email_num, #password, #birthdate{
            width:50%;
            padding: 7px;
            margin: 10px;
            border: 2px solid rgb(28, 119, 255);
            border-radius: 6px;
        }
        button{
            width:50%;
            padding: 12px;
            border: 0;
            background-color:rgb(0, 168, 70);
            font-size:20px;
            color:white;
            border-radius: 6px;
        }
        .con, .header{
            text-align:center;
            padding-top: 50px;
        }
        .header{
            font-size: 50px;
            color:rgb(45, 101, 255);
            font-weight:bold;
            margin-bottom: 17px;
        }
        #male, #female, #other{
        }
        .text{
            margin-top: 40px;
        }
    </style>
</head>

<body>

<div class="con" >
    <div class="header">Sign Up</div>
    <form action="sign-up" method="post">

        <input type="text" name="firstname" id="firstname" placeholder="First Name"><br>

        <input type="text" name="lastname" id="lastname" placeholder="Last Name"><br>

        <input type="email" name="email" id="email" placeholder="Email"><br>

        <input type="password" name="password" id="password" placeholder="Password"><br>


        <input type="date" name="dob" id="dob" placeholder="Date of birth"><br>

<%--        <label  id="gen"><b>Gender: </b></label>--%>

<%--        <input type="radio" id="male" name="gender" value="male">--%>
<%--        <label for="male">Male</label>--%>
<%--        <input type="radio" id="female" name="gender" value="female">--%>
<%--        <label for="female">Female</label>--%>



        <div class="text">By clicking Sign Up, you agree to our Terms, Data Policy and Cookie Policy. You may
            receive SMS notifications from us and can opt out at any time.</div>

        <button type="submit" style="margin-top: 20px;">Sign Up</button>
    </form>
</div>
</body>

</html>