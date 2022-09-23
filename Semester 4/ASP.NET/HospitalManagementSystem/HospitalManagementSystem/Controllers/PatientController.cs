using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using HospitalManagementSystem.Data;
using HospitalManagementSystem.Models;

namespace HospitalManagementSystem.Controllers
{
    public class PatientController : Controller
    {
        private readonly ApplicationDbContext _db;

        public PatientController(ApplicationDbContext db)
        {
            _db = db;
        }

        //INDEX
        public IActionResult Index()
        {
            var patientsList = _db.Patient.ToList();

            foreach (var patient in patientsList) 
            {
                patient.Doctor = _db.Doctor.Find(patient.DoctorID);
            }

            return View(patientsList);
        }

        // SEARCH
        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Search(string searchTerm)
        {
            var searchPatientsList = _db.Patient.Where(s => s.Name!.Contains(searchTerm)).ToList();

            foreach (var patient in searchPatientsList) 
            {
                patient.Doctor = _db.Doctor.Find(patient.DoctorID);
            }

            return View(searchPatientsList);
        }


        // CREATE GET
        public IActionResult Create()
        {
            ViewData["DoctorID"] = new SelectList(_db.Doctor, "Id", "Name");
            return View();
        }

        // CREATE POST
        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Create([Bind("Id,DoctorID,Name")] Patient patient)
        {
            if (patient.Name == null) 
            {
                ViewData["DoctorID"] = new SelectList(_db.Doctor, "Id", "Name");
                return View(patient);
            }

            _db.Add(patient);
            _db.SaveChanges();
            return RedirectToAction("Index");
        }

        // EDIT GET
        public IActionResult Edit(int? id)
        {
            if (id == null || id == 0)
            {
                return NotFound();
            }

            var patient = _db.Patient.Find(id);
            
            if (patient == null)
            {
                return NotFound();
            }
            
            ViewData["DoctorID"] = new SelectList(_db.Doctor, "Id", "Name", patient.DoctorID);
            return View(patient);
        }

        // EDIT POST
        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Edit(int id, [Bind("Id,DoctorID,Name")] Patient patient)
        {
            if (id != patient.Id)
            {
                return NotFound();
            }

            if (patient.Name == null) 
            {
                ViewData["DoctorID"] = new SelectList(_db.Doctor, "Id", "Name", patient.DoctorID);
                return View(patient);
            }

            _db.Update(patient);
            _db.SaveChanges();
            return RedirectToAction("Index");
            
        }

        // DELETE GET
        public IActionResult Delete(int? id)
        {
            if (id == null || id == 0)
            {
                return NotFound();
            }

            var patientFromDb = _db.Patient.Find(id);

            if (patientFromDb == null)
            {
                return NotFound();
            }

            ViewData["DoctorName"] = _db.Doctor.Find(patientFromDb.DoctorID).Name;
            return View(patientFromDb);
        }

        // DELETE POST
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public IActionResult DeletePOST(int id)
        {
            var patient = _db.Patient.Find(id);

            if (patient == null)
            {
                return NotFound();
            }

            _db.Patient.Remove(patient);
            _db.SaveChanges();
            return RedirectToAction("Index");
        }
    }
}
