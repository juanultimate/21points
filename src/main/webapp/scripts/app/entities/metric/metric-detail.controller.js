'use strict';

angular.module('21pointsApp')
    .controller('MetricDetailController', function ($scope, $rootScope, $stateParams, entity, Metric, Y, Goal) {
        $scope.metric = entity;
        $scope.load = function (id) {
            Metric.get({id: id}, function(result) {
                $scope.metric = result;
            });
        };
        var unsubscribe = $rootScope.$on('21pointsApp:metricUpdate', function(event, result) {
            $scope.metric = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
