angular.module('app', []).controller('indexController', function ($scope, $http) {

    const contextPath = 'http://localhost:8189'
    let page = 0;
    let size = 4;


    $scope.fillTable = function () {
        $http.get(contextPath + '/api/v1/product/?page=' + page + '&size=' + size)
            .then(function (resp) {
                $scope.products = resp.data
            });
    };

    $scope.increment = function () {
        page++;
        $scope.fillTable()
    };

    $scope.decrement = function () {
        if (page > 0) {
            page--;
            $scope.fillTable()
        }
    };

    $scope.editSize = function () {
        size = $scope.sizePage;
        $scope.fillTable()
    }

    $scope.saveProduct = function () {
        $http.post(contextPath + '/product', $scope.newProduct)
            .then(function () {
                $scope.fillTable()
            });
    };

    $scope.removeProduct = function (id) {
        $http.delete(contextPath + '/product/'+id)
            .then(function () {
                $scope.fillTable()
            });
    };

    $scope.fillTable()
});