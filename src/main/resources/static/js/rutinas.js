let salario = /*[[${salario}]]*/ 0;

function mostrarSalario() {
    document.getElementById('totalSalario').textContent = `₡${salario.toLocaleString('es-CR')}`;
}

function actualizarTotales() {
    let total = 0;
    document.querySelectorAll('tr').forEach(row => {
        const montoTd = row.querySelector('.monto');
        const cantidadTd = row.querySelector('.cantidad');
        if (montoTd && cantidadTd) {
            const monto = parseFloat(montoTd.textContent.replace(/[₡,]/g, '')) || 0;
            const cantidad = parseInt(cantidadTd.textContent) || 0;
            total += monto * cantidad;
        }
    });
    document.getElementById('totalGastos').textContent = `₡${total.toLocaleString('es-CR')}`;
    return total;
}

function actualizarSobrantes() {
    let totalGastos = 0;
    document.querySelectorAll('tr').forEach(row => {
        const montoTd = row.querySelector('.monto');
        const cantidadTd = row.querySelector('.cantidad');
        if (montoTd && cantidadTd) {
            const monto = parseFloat(montoTd.textContent.replace(/[₡,]/g, '')) || 0;
            const cantidad = parseInt(cantidadTd.textContent) || 0;
            totalGastos += monto * cantidad;
        }
    });
    document.getElementById('totalSobrantes').textContent = `₡${(salario - totalGastos).toLocaleString('es-CR')}`;
}

document.addEventListener('DOMContentLoaded', function() {
    mostrarSalario();
    actualizarTotales();

    const inputSalario = document.getElementById('inputSalario');
    // Solo filtra caracteres no numéricos en vivo
    inputSalario.addEventListener('input', function () {
        this.value = this.value.replace(/[^\d]/g, ''); // Solo deja números
    });
});

function actualizarSalario() {
    const inputSalario = document.getElementById('inputSalario');
    // Saca los símbolos por si acaso, aunque ya no deberían existir
    const raw = inputSalario.value.replace(/[₡,]/g, '').trim();
    const nuevoSalario = parseInt(raw);

    if (!isNaN(nuevoSalario) && nuevoSalario >= 0) {
        salario = nuevoSalario;
        mostrarSalario();
        actualizarSobrantes();

        // Cerrar el modal
        const modal = bootstrap.Modal.getInstance(document.getElementById('modalSalario'));
        modal.hide();
    } else {
        alert("Por favor, ingrese un número válido.");
    }
}
