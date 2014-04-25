$(function(){
	prepare();
});

function prepare(){
	$("button").bind("click", sendObjectToServer);
}

function sendObjectToServer(){
	var obj = makeData();alert(1);
	$.ajax({
		type : "POST",
		url : "receiveObject/receiveObject.action",
		data : {
			jsonString : JSON.stringify(obj)
		},
		dataType: 'json',
		success : function(json) {
			if (json.flag) {
			} else {
//				alert("操作失败，请重试！");
			}
		}
	});
}

function makeData(){
	var models = new Array();
	models.push(new TestModel("tmId1", "tmName1"));
	models.push(new TestModel("tmId2", "tmName2"));
	models.push(new TestModel("tmId3", "tmName3"));
	models.push(new TestModel("tmId4", "tmName4"));
	return new ReceiveObject("id1", "name1", models);
}

function TestModel(modelId, modelName){
	this.modelId = modelId;
	this.modelName = modelName;
}

function ReceiveObject(id, name, models){
	this.id = id;
	this.name = name;
	this.models = models;
}