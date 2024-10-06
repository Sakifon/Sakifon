<%@ tag body-content="scriptless" %>
<%@ attribute name="pageTitle" required="true" type="java.lang.String" %>

<html>
<head>
    <title>${pageTitle}</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.js"></script>
    <style>
        body {
            font-family: 'Open Sans', sans-serif;
            font-size: 16px;
            line-height: 1.6;
            color: #333;
            background-image: url('../images/img.png');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
    </style>
</head>

<jsp:doBody/>

</html>