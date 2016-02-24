'use strict';

describe('Controller Tests', function() {

    describe('Metric Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockMetric, MockY, MockGoal;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockMetric = jasmine.createSpy('MockMetric');
            MockY = jasmine.createSpy('MockY');
            MockGoal = jasmine.createSpy('MockGoal');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'Metric': MockMetric,
                'Y': MockY,
                'Goal': MockGoal
            };
            createController = function() {
                $injector.get('$controller')("MetricDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = '21pointsApp:metricUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
