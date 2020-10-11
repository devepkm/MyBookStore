$(function () {

    //refresh verification code
    $("#codeimg").click(function (){
        this.src = $("base").attr("href") + "kaptchaServlet.jpg";
    });

    $("#sub_btn").click(function () {
        // verify username, password, confirm password, email, verification code


        var usernameText = $("#username").val();
        //word, number, _ and length between 5-12
        var usernamePatt = /^\w{5,12}$/;

        if (!usernamePatt.test(usernameText)) {
            $("span.errorMsg").text("Invalid Username! ")
            return false;
        }

        var passwordText = $("#password").val();
        if (!usernamePatt.test(passwordText)) {
            $("span.errorMsg").text("Invalid Password! ")
            return false;
        }


        var repwText = $("#repwd").val();
        if (repwText != passwordText) {
            $("span.errorMsg").text("Incorrect Confirmed Password! ")
            return false;
        }

        var emailText = $("#email").val();
        var emailPatt = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if (!emailPatt.test(emailText)) {
            $("span.errorMsg").text("Invalid Email! ")
            return false;
        }

        // only verify if verification code is not null
        var codeText = $("#code").val();
        if (codeText == "") {
            $("span.errorMsg").text("Invalid Verification Code! ")
            return false;
        }


        //clean all error msg
        $("span.errorMsg").text("")

    });
});


