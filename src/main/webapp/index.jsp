<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String role = (String) session.getAttribute("role"); %>
<t:layout pageTitle="List des Cours">
    <body>
    <nav class="bg-white border-gray-200 dark:bg-gray-900">
        <div class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">

            <a href="menu/index.jsp" class="flex items-center space-x-3 rtl:space-x-reverse">

                <span class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">

                    School Management
                </span>
            </a>
            <button data-collapse-toggle="navbar-default" type="button" class="inline-flex items-center p-2 w-10 h-10 justify-center text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600" aria-controls="navbar-default" aria-expanded="false">
                <span class="sr-only">Open main menu</span>
                <svg class="w-5 h-5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 17 14">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 1h15M1 7h15M1 13h15"/>
                </svg>
            </button>
            <div class="hidden w-full md:block md:w-auto" id="navbar-default">
                <ul class="font-medium flex flex-col p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-gray-50 md:flex-row md:space-x-8 rtl:space-x-reverse md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700">
                    <li>
                        <a href="/listCours" class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent" aria-current="page">Liste des cours</a>
                    </li>
                    <li>
                        <a href="/notes" class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent">Liste des notes</a>
                    </li>
                    <li>
                        <a href="/logout" class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent">Déconnexion</a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>
    <div class="container mx-auto px-4">
        <div class="flex flex-col mt-8">
            <div class="flex justify-start">

                    <input id="searchInput" type="text" name="search" placeholder="Rechercher par nom de cours" class="border-2 border-gray-300 bg-white h-10 px-5 pr-16 rounded-lg text-sm focus:outline-none">


            </div>
            <c:if test="${role != 'student'}">
            <div class="flex justify-end">
                <a href="/cours/create.jsp" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded my-3">Ajouter un cours</a>
            </div>
            </c:if>

            <div class="overflow-x-auto sm:-mx-6 lg:-mx-8">


                <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
                    <div class="shadow overflow-hidden border-b border-gray-200 sm:rounded-lg">
                        <table class="min-w-full divide-y divide-gray-200">
                            <thead class="bg-gray-50">
                            <tr>
                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                    Nom
                                </th>
                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                    Description
                                </th>
                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                    Date de debut
                                </th>
                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                    Date de fin
                                </th>
                                <c:if test="${role != 'student'}">
                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                    Actions
                                </th>
                                </c:if>
                            </tr>
                            </thead>
                            <tbody class="bg-white divide-y divide-gray-200" id="searchResults">
                            <c:if test="${empty cours}">
                                <tr>
                                    <td colspan="5" class="px-6 py-4 whitespace-nowrap">
                                        <div class="text-sm text-gray-500">
                                            Aucun cours trouvé
                                        </div>
                                    </td>
                                </tr>
                            </c:if>


                            <c:forEach items="${cours}" var="cours" >
                                <tr>
                                    <td class="px-6 py-4 whitespace-nowrap">
                                        <div class="flex items
                                        -center">
                                            <div class="flex-shrink-0 h-10 w-10">

                                                <c:out value="${cours.id}"/>
                                            </div>
                                            <div class="ml-4">
                                                <div class="text-sm font-medium text-gray-900">
                                                    <c:out value="${cours.nom}"/>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="px-6 py-4 whitespace-nowrap">
                                        <div class="text-sm text-gray-900">
                                            <c:out value="${cours.description}"/>
                                        </div>
                                    </td>
                                    <td class="px-6 py-4 whitespace-nowrap">
                                        <span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800">
                                            <c:out value="${cours.dateDebut}"/>
                                        </span>
                                    </td>
                                    <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                                        <c:out value="${cours.dateFin}"/>
                                    </td>
                                    <c:if test="${role != 'student'}">
                                    <td class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium">
                                        <a href="/CoursEdit?id=<c:out value="${cours.id}"/>"
                                           class="text-indigo-600 hover:text-indigo-900">Modifier</a>
                                        <a href="/CoursDelete?id=<c:out value="${cours.id}"/>"
                                           class="text-red-600 hover:text-red-900">Supprimer</a>
                                    </td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                            </tbody>

                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
    <script>
        const searchInput = document.getElementById('searchInput');
        const searchResults = document.getElementById('searchResults');

        searchInput.addEventListener('input', function (e) {
            const searchValue = e.target.value;
            fetch('/CoursSearch?searchTerm=' + searchValue)
                .then(response => response.json())
                .then(data => {
                    let newHtml = ''
                    data.forEach(function(cours) {
                        newHtml += '<tr>';
                        newHtml += '<td class="px-6 py-4 whitespace-nowrap"><div class="flex items-center"><div class="flex-shrink-0 h-10 w-10">' + cours.id + '</div><div class="ml-4"><div class="text-sm font-medium text-gray-900">' + cours.nom + '</div></div></div></td>';
                        newHtml += '<td class="px-6 py-4 whitespace-nowrap"><div class="text-sm text-gray-900">' + cours.description + '</div></td>';
                        newHtml += '<td class="px-6 py-4 whitespace-nowrap"><span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800">' + cours.dateDebut + '</span></td>';
                        newHtml += '<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">' + cours.dateFin + '</td>';
                        newHtml += '<td class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium"></td>';
                        newHtml += '</tr>';
                    });
                    searchResults.innerHTML = newHtml;
                });
        });


    </script>
</t:layout>