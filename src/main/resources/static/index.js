angular.module('app', []).controller('indexController', function ($scope, $http) {

    const contextPath = 'http://localhost:8189'

    $scope.fillTable = function () {
        $http.get(contextPath + '/product')
            .then(function (resp) {
                $scope.products = resp.data
            })
    };

    $scope.saveProduct = function () {
        $http.post(contextPath + '/product', $scope.newProduct)
            .then(function () {
                $scope.fillTable()
            });
    };

    $scope.removeProduct = function (id){
        $http.delete(contextPath + '/product/'+id)
            .then(function () {
                $scope.fillTable()
            })
    }

    $scope.fillTable()
});