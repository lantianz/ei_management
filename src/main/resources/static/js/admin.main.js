$(document).ready(function () {
    // 给头像添加点击事件
    $('#avatar').click(function (event) {
        event.stopPropagation();  // 阻止事件冒泡
        $('#dropdown').toggle();
    });
    $('#dropdown').mouseenter(function () {
        $('#dropdown').show();
    }).mouseleave(function () {
        $('#dropdown').hide();
    });
    $('#dropdown a').click(function() {
        $('#dropdown').hide();
    });
    // 给 document 添加点击事件监听
    $(document).click(function (event) {
        // 如果点击的元素不是下拉框或者头像，则隐藏下拉框
        if (!$(event.target).closest('#dropdown').length && !$(event.target).is('#avatar')) {
            $('#dropdown').hide();
        }
    });


    // 给导航栏的每一项添加点击事件
    $('nav ul li a').click(function (event) {
        event.preventDefault();

        // 关闭其他打开的下拉菜单
        $('nav ul li ul').not($(this).next('ul')).slideUp(200);
        $('nav ul li a').not($(this)).removeClass('active');
        $('nav ul li a iconpark-icon').attr("name", "drop-left");

        // 获取点击项的子菜单
        const $submenu = $(this).next('ul');
        // 获取点击项的图标
        const $icon = $(this).find('iconpark-icon');
        // 切换当前项的状态
        $(this).toggleClass('active');

        // 显示或隐藏子菜单
        $submenu.slideToggle(200);

        // 根据当前状态设置图标内容
        if ($(this).hasClass('active')) {
            $icon.attr("name", "drop-down");
        } else {
            $icon.attr("name", "drop-left");
        }
    });


    // 假设我们有一个全局变量currentUser表示当前登录的用户
    if (currentUser.role === 'admin') {
        $('#admin-nav').show();
    }
});

//  菜单按钮
    $('#menu-button').click(function () {
        const navLinks = document.getElementById("nav");
        const $icon = $(this).find('iconpark-icon');
        if (navLinks.style.display === 'none') {
            navLinks.style.display = 'flex';
            $icon.attr("name", "menu-fold");
        } else {
            navLinks.style.display = 'none';
            $icon.attr("name", "menu-unfold");
        }
    });

//  iframe
function insertIframe(url, containerId) {
    // 创建一个 iframe 元素
    const iframe = document.createElement('iframe');

    // 设置 iframe 的属性
    iframe.src = url;
    iframe.width = "100%";
    iframe.height = "100%";

    // 将 iframe 插入到指定的容器元素中
    const container = document.getElementById(containerId);
    if (container) {
        container.appendChild(iframe);
    } else {
        console.error('找不到容器元素');
    }
}
// 使用，执行前先清空content
function action(id) {
    document.getElementById('content').innerHTML = '';
    if (id === 1) {
        insertIframe('/graduates/graduateInfo?action=1', 'content');
    } else if (id === 2) {
        insertIframe('/employmentInfos/employmentInfo?action=2', 'content');
    } else if (id === 3) {
        insertIframe('/admins/adminInfo?action=', 'content');
    }
}

function Table(containerId) {
    // 获取表格容器
    const tableContainer = document.getElementById(containerId);
    // 创建表格元素
    const table = document.createElement('table');
    table.id = 'table';

    // 创建表头元素（thead）
    const thead = document.createElement('thead');
    table.appendChild(thead);

    // 创建表头行
    const headerRow = document.createElement('tr');
    // 获取表头字段名
    const headers = Object.keys(data[0]);
    // 创建表头单元格并设置内容
    headers.forEach(header => {
        const cell = document.createElement('th');
        cell.textContent = header;
        headerRow.appendChild(cell);
    });

    // 添加“操作”列的表头单元格
    const actionsHeader = document.createElement('th');
    actionsHeader.textContent = '操作';
    headerRow.appendChild(actionsHeader);

    // 将表头行添加到 thead 中
    thead.appendChild(headerRow);

    // 创建表体元素（tbody）
    const tbody = document.createElement('tbody');
    table.appendChild(tbody);

    // 创建数据行
    data.forEach(item => {
        const row = document.createElement('tr');
        // 遍历每个字段，创建单元格并设置内容
        headers.forEach(header => {
            const cell = document.createElement('td');
            cell.textContent = item[header];
            row.appendChild(cell);
        });

        // 创建“操作”列的单元格
        const actionsCell = document.createElement('td');

        // 创建修改按钮
        const editButton = document.createElement('button');
        editButton.textContent = '修改';
        editButton.className = 'bg-green-500 rounded-lg text-white py-1 px-2 m-1 text-center text-xs cursor-pointer';
        // 添加修改操作的事件监听器，可以根据需要编写相应的逻辑
        editButton.addEventListener('click', () => {
            // 执行修改操作，可以根据需要编写相应的逻辑
            console.log('执行修改操作', item);
        });

        // 创建删除按钮
        const deleteButton = document.createElement('button');
        deleteButton.textContent = '删除';
        deleteButton.className = 'bg-green-500 rounded-lg text-white py-1 px-2 m-1 text-center text-xs cursor-pointer';
        // 添加删除操作的事件监听器，可以根据需要编写相应的逻辑
        deleteButton.addEventListener('click', () => {
            // 执行删除操作，可以根据需要编写相应的逻辑
            console.log('执行删除操作', item);
        });

        // 将按钮添加到“操作”列的单元格
        actionsCell.appendChild(editButton);
        actionsCell.appendChild(deleteButton);

        // 将“操作”列的单元格添加到数据行
        row.appendChild(actionsCell);

        // 将数据行添加到 tbody 中
        tbody.appendChild(row);
    });

    // 将表格添加到容器中
    tableContainer.appendChild(table);
}


