let searchBtn = $("#searchBtn");
let resultList = $("#resultList");

searchBtn.on("click", searchBtnHandler);

// click event
function searchBtnHandler() {
    const urlInputValue = $("#urlInput").val();

    $.ajax({
        url: "/rest/search",
        type: "POST",
        headers: {
            "Accept" : "application/json",
            "Content-Type" : "application/json",
        },
        data: JSON.stringify({
            "searchUrl" : urlInputValue,
        }),
        dataType: "json",
        success: function (result) {
            if(result) {
                console.log(result);

                listHandler(result);

            } else {
                console.log("error");
            }
        }
    })
}

// 유효성 검사
function invalidCheck(urlInputValue) {






}



function listHandler(result) {
    let innerHTML = "";

    for(key in result) {
        innerHTML += listUIHandler(key, result[key]);
    }

    resultList.html("");
    resultList.append(innerHTML);
}


// make list
function listUIHandler(key, value) {

    const listUI = `
        <tr>
            <td className="px-4 border-top">
                <div className="d-flex align-items-center">
                    ${key}
                </div>
            </td>
            <td className="px-4 border-top text-end">${value}</td>
        </tr>`;

    return listUI;
}



// 유효성 검사