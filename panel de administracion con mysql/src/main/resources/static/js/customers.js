function init() {
    renderCustomers();
}

async function getCustomers() {
    let url = URL_SERVER + 'customer';

    let config = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': sessionStorage.token
        }
    }

    let response = await fetch(url, config);
    let json = await response.json();
    return json;
    /*
    return [
        {
            "id": 1,
            "firstname": "Lucas",
            "lastname": "Moy",
            "email": "lucasmoy@gmail.com",
            "address": "Siempre viva 123"
        },
        {
            "id": 2,
            "firstname": "Maria",
            "lastname": "Moy",
            "email": "mariamoy@gmail.com",
            "address": "Siempre viva 123"
        }
    ];
    */
}

async function renderCustomers() {
    let customers = await getCustomers();
    let html = '';
    for (let customer of customers) {
        html += getHtmlRowCustomer(customer);
    }

    let tbody = document.getElementById('tbody-customers');
    tbody.innerHTML = html;
}


async function onClickEdit(id) {
    window.location.href = 'modify-customer.html?id=' + id;
}

async function onClickRemove(id) {
    let response = confirm("Do you want remove this?");
    if (!response) {
        return;
    }

    let url = URL_SERVER + 'customer/' + id;
    let config = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': sessionStorage.token
        }
    };

    await fetch(url, config);
    renderCustomers();
}

function getHtmlRowCustomer(customer) {
    return `<tr>
        <td>${customer.id}</td>
        <td>${customer.firstname} ${customer.lastname}</td>
        <td>${customer.address}</td>
        <td>${customer.email}</td>
        <td>
            <a href="#" onClick="onClickEdit(${customer.id})" class="btn btn-primary btn-circle btn-sm">
                <i class="fas fa-edit"></i>
            </a>

            <a href="#" onClick="onClickRemove(${customer.id})" class="btn btn-danger btn-circle btn-sm">
                <i class="fas fa-trash"></i>
            </a>

        </td>
    </tr>`;
}

init();