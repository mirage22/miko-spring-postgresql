var sPostgreSQLAppServices = angular.module('sPostgreSQLAppServices', ['ngResource']);

sPostgreSQLAppServices.factory('EntityA', ['$resource',
    function($resource){
        return $resource('api/:entityAId.json', {}, {
            result: { method:'GET', isArray: false, params:{ entityAId: 'entityAListDTO'}}
        });
    }
]);

