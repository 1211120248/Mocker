$(function () {
    $("#tree").treetable({ expandable: true });

});

var vm = new Vue({
    el: '#tree',
    methods:{
        getMenuList:function (event) {
            $.getJSON("/menu", function(r){
                vm.menuList = r.data;
            });
        }
    },
    created:function(){
        this.getMenuList();
    },
    data: {
        menuList:{}
    }
})

