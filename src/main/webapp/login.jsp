<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:layout pageTitle="Login">
<body class="bg-gray-100 p-6">
<div class="max-w-md mx-auto bg-white rounded-md shadow-md p-6">
    <h2 class="text-lg font-semibold mb-4">Login</h2>
    <form action="/login" method="post">

        <div class="mb-4">
            <label for="email" class="block text-gray-700 font-semibold mb-2">Email:</label>
            <input type="email" id="email" name="email" class="form-input w-full py-3 px-2 border border-dark" placeholder="Enter your email" required>
        </div>

        <c:if test="${param.error == 'emailValidation'}">
            <div class="text-red-500 mb-4">
                Email must be a valid email address (i.e. joe.doe@gmail.com)
            </div>
        </c:if>

        <div class="mb-6">
            <label for="password" class="block text-gray-700 font-semibold mb-2">Password:</label>
            <input type="password" id="password" name="password" class="form-input w-full py-3 px-2 border border-dark" placeholder="Enter your password" required>
        </div>

        <c:if test="${param.error == 'passwordValidation'}">
            <div class="text-red-500 mb-4">
                Password must be a valid password (i.e. 8 characters, 1 uppercase, 1 lowercase, 1 number, 1 special character)
            </div>
        </c:if>
        <div>
            <button type="submit" class="bg-blue-500 hover:bg-blue-600 text-white font-semibold py-2 px-4 rounded">Submit</button>
        </div>
    </form>
</div>
</body>
</t:layout>