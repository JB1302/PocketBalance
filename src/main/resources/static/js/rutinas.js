document.addEventListener('DOMContentLoaded', () => {
    const salarioElement = document.getElementById('totalSalario');
    const salario = parseFloat(salarioElement.getAttribute('data-salario')) || 0;

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

    // Actualiza ambos elementos: gastos y sobrantes
    const totalGastosElement = document.getElementById('totalGastos');
    const totalSobrantesElement = document.getElementById('totalSobrantes');

    if (totalGastosElement) {
        totalGastosElement.textContent = `₡${total.toLocaleString('es-CR')}`;
    }

    if (totalSobrantesElement) {
        totalSobrantesElement.textContent = `₡${(salario - total).toLocaleString('es-CR')}`;
    }
});
