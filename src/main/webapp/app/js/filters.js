'use strict'

angular.module('sPostgreSQLAppFilters', []).filter('checkmark', function(){
    return function(input){
        return input ? '\u2713' : '\u2718';
    }
});
