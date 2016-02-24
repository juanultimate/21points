'use strict';

angular.module('21pointsApp')
	.controller('MetricDeleteController', function($scope, $uibModalInstance, entity, Metric) {

        $scope.metric = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            Metric.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
