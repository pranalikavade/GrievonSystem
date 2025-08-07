// Show form section, hide welcome section
function showForm() {
  document.getElementById("welcome-section").style.display = "none";
  document.getElementById("form-section").style.display = "block";
}

document.getElementById("role").addEventListener("input", function () {
  const typeList = document.getElementById("typeOptions");
  typeList.innerHTML = ""; // clear previous options

  const role = this.value;
  let options = [];

  if (role === "Student") {
    options = ["Fees Issue", "Exam Issue", "Scholarship Delay"];
  } else if (role === "Citizen") {
    options = ["Road Damage", "Garbage Issue", "Water Supply"];
  } else if (role === "Employee") {
    options = ["Salary Delay", "Workplace Harassment", "Leave Issue"];
  }

  options.forEach(item => {
    const opt = document.createElement("option");
    opt.value = item;
    typeList.appendChild(opt);
  });
});

// ✅ Function to generate random status
function getRandomStatus() {
  const statuses = ["Pending", "Approved", "Processing"];
  const index = Math.floor(Math.random() * statuses.length);
  return statuses[index];
}

// ✅ Form submission with backend connection
document.getElementById("complaintForm").addEventListener("submit", function (e) {
  e.preventDefault();

  // Get values from form
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;
  const role = document.getElementById("role").value;
  const type = document.getElementById("type").value;
  const details = document.getElementById("details").value;

  const status = getRandomStatus();

  const complaintData = {
    name: name,
    email: email,
    role: role,
    type: type,
    details: details,
    status: status
  };

  // ✅ Backend connection using fetch
  fetch("http://localhost:9089/api/complaints", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(complaintData)
  })
    .then(response => {
      if (!response.ok) {
        throw new Error("Failed to submit complaint");
      }
      return response.json();
    })
    .then(data => {
      // Insert into table
      const tableBody = document.getElementById("dataTableBody");
      const newRow = document.createElement("tr");

      newRow.innerHTML = `
        <td>${data.name}</td>
        <td>${data.email}</td>
        <td>${data.role}</td>
        <td>${data.type}</td>
        <td>${data.details}</td>
        <td>${data.status}</td>
      `;
      tableBody.appendChild(newRow);

      // Show popup
      const popup = document.getElementById("popupMessage");
      popup.style.display = "block";

      // Show submitted data section
      document.getElementById("submittedDataContainer").style.display = "block";

      // Hide popup after 3 seconds and reset form
      setTimeout(() => {
        popup.style.display = "none";
        document.getElementById("complaintForm").reset();
      }, 3000);
    })
    .catch(error => {
      alert("Error submitting complaint: " + error.message);
    });
});
