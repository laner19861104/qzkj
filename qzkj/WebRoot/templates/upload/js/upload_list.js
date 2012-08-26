var params;
$(function() {
    $("#file_upload_1").uploadify({
        height        	: 16,
        width         	: 80,
        swf           	: 'templates/uploadify-v3.1/uploadify.swf',
        uploader      	: 'uploadfile.action',
        auto			: true,
        multi			: true,
        fileObjName		: 'file',
        debug			: false,
        method			: 'post',
        formData		: {},
        queueSizeLimit 	: 3,
        buttonText    	: '上传视频',
        removeCompleted : false,

        onUploadStart: function(file) {//上传开始时触发（每个文件触发一次）
			params = {"fname" : encodeURIComponent(encodeURIComponent(file.name)), "fsize" : file.size, "ftype" : file.type};
			$('#file_upload_1').uploadify('settings','formData',params);
		},
		onUploadSuccess : function(file,data,response) {//上传完成时触发（每个文件触发一次）
			　　alert( 'id: ' + file.id
			　　+ ' - 索引: ' + file.index
			　　+ ' - 文件名: ' + file.name
			　　+ ' - 文件大小: ' + file.size
			　　+ ' - 类型: ' + file.type
			　　+ ' - 创建日期: ' + file.creationdate
			　　+ ' - 修改日期: ' + file.modificationdate
			　　+ ' - 文件状态: ' + file.filestatus
			　　+ ' - 服务器端消息: ' + data
			　　+ ' - 是否上传成功: ' + response);
			}
    });
});