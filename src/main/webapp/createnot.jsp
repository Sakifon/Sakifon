<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:layout pageTitle="Ajouter Un Cours">
    
    <nav class="bg-white border-gray-200 dark:bg-gray-900">
        <div class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
            <a href="/menu/index.jsp" class="flex items-center space-x-3 rtl:space-x-reverse">

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
    <div class="container mx-auto">
        <div class="flex justify-center px-6 my-12">
            <!-- Row -->

            <!-- Col -->

            <!-- Col -->
            <div class="w-full lg:w-1/2 bg-white p-5 rounded-lg lg:rounded-l-none">
                <h3 class="pt-4 text-2xl text-center">Ajouter des notes</h3>
                <form class="px-8 pt-6 pb-8 mb-4 bg-white rounded" method="post" action="/storeNote">
                    <div class="mb-4">
                        <label class="block mb-2 text-sm font-bold text-gray-700" for="nom">
                            Nom du Etudiant
                        </label>
                        <select name="user_id" id="nom" class="w-full px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline">
                            <option value="0">Selectionner un etudiant</option>
                            <c:forEach items="${etudiants}" var="etudiant">
                                <option value="${etudiant.id}">${etudiant.firstName} ${etudiant.lastName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-4">
                        <label class="block mb-2 text-sm font-bold text-gray-700" for="nomCour">
                            Nom du Cours
                        </label>
                        <select name="cours_id" id="nomCour" class="w-full px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline">
                            <option value="0">Selectionner un cours</option>
                            <c:forEach items="${cours}" var="cour">
                                <option value="${cour.id}">${cour.nom}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-4">
                        <label class="block mb-2 text-sm font-bold text-gray-700" for="note1">
                            Note 1
                        </label>
                        <input
                                class="w-full px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
                                id="note1"
                                name="note1"
                                type="text"
                                placeholder="Note 1"
                        />
                    </div>
                    <div class="mb-4">
                        <label class="block mb-2 text-sm font-bold text-gray-700" for="note2">
                            Note 2
                        </label>
                        <input
                                class="w-full px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
                                id="note2"
                                name="note2"
                                type="text"
                                placeholder="Note 2"
                        />
                    </div>
                    <div class="mb-4">
                        <label class="block mb-2 text-sm font-bold text-gray-700" for="note3">
                            Note 3
                        </label>
                        <input
                                class="w-full px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
                                id="note3"
                                name="note3"
                                type="text"
                                placeholder="Note 3"
                        />
                    </div>
                    <div class="mb-4">
                        <label class="block mb-2 text-sm font-bold text-gray-700" for="note4">
                            Note 4
                        </label>
                        <input
                                class="w-full px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
                                id="note4"
                                name="note4"
                                type="text"
                                placeholder="Note 4"
                        />
                    </div>
                    <div class="mb-6 text-center">
                        <button
                                class="w-full px-4 py-2 font-bold text-white bg-blue-500 rounded-full hover:bg-blue-700 focus:outline-none focus:shadow-outline"
                                type="submit"
                        >
                            Ajouter
                        </button>
                    </div>
                </form>
            </div>

        </div>
    </div>

</t:layout>