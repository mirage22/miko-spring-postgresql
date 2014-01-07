'use strict';

var sPostgreSQLApp = angular.module('sPostgreSQLApp', [
    'ngRoute',
    'sPostgreSQLAppControllers',
    'sPostgreSQLAppFilters',
    'sPostgreSQLAppServices'
]);

sPostgreSQLApp.config(['$routeProvider',
    function($routeProvider){
        $routeProvider.
            when('/entityA',{
                templateUrl: 'template/entityAList.html',
                controller: 'EntityAListCtrl'
            }).
            when('/entityA/:entityAId', {
                templateUrl: 'app/template/entityADetail.html',
                controller: 'EntityADetailCtrl'
            }).
            otherwise({
                redirectTo: '/entityA'
            })
    }
]);


