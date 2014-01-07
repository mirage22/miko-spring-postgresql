'use strict'

var sPostgreSQLAppControllers = angular.module('sPostgreSQLAppControllers', []);

sPostgreSQLAppControllers.controller('EntityAListCtrl', ['$scope', 'EntityA',
    function($scope, EntityA) {


        $scope.entityAList = EntityA.result(function(data){
            return data;
        });
        $scope.orderProp = 'value';

    }
]);

sPostgreSQLAppControllers.controller('EntityADetailCtrl', ['$scope', '$routeParams', 'EntityA',
    function($scope, $routeParams, EntityA){
        $scope.entityA = EntityA.get({entityAId: $routeParams.entityAId},
            function(entityA){
                $scope.name = entityA.name;
        });

        $scope.setName = function(name){
            $scope.name = name;
        }
    }
]);
