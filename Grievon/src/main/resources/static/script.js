document.getElementById('complaintForm').addEventListener('submit', function (e) {
  e.preventDefault();

  // Input values घ्या
  const name = document.getElementById('name').value.trim();
  const email = document.getElementById('email').value.trim();
  const complaint = document.getElementById('complaintText').value.trim();

  // Success message दाखवा
  const successMessage = document.getElementById('successMessage');
  successMessage.style.display = 'block';

  // Complaint Status section मध्ये entry add करा
  const statusList = document.getElementById('complaintStatusList');
  const complaintEntry = document.createElement('div');
  complaintEntry.classList.add('complaint-entry');
  complaintEntry.innerHTML = `
    <p><strong>Name:</strong> ${name}</p>
    <p><strong>Email:</strong> ${email}</p>
    <p><strong>Complaint:</strong> ${complaint}</p>
    <p><strong>Status:</strong> Processing</p>
  `;
  statusList.appendChild(complaintEntry);

  // Form reset करा
  document.getElementById('complaintForm').reset();
});
