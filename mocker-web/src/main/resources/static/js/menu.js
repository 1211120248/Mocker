$(function(){
    $('#tt').treegrid({
        fit:true,
        fitColumns:true,
        url:'/menu',
        method:"get",
        idField:'id',
        treeField:'name',
        columns:[[
            {field:'name',title:'菜单名称',width:"20%"},
            {field:'type',title:'菜单类型',width:"10%"},
            {field:'url',title:'菜单路径',width:"50%"},
            {field:'permission',title:'菜单权限',width:"10%"},
            {field:'sort',title:'菜单顺序',width:"10%"}
        ]],
        loadFilter:function(result){
            var data = result.data;
            if (data){
                data.total = data.totalCount;
                return data;
            }
        }
    });
});

var vm = new Vue({
    el:'#app',
    data:{
    },
    methods: {
        saveMenu:function(){
            $("#saveModal").modal('show');
        },
        close:function(){
            $("#saveModal").modal('hide');
        }
    }
});



