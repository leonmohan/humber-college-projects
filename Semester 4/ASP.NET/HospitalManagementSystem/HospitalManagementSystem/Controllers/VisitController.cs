using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using HospitalManagementSystem.Data;
using HospitalManagementSystem.Models;

namespace HospitalManagementSystem.Controllers
{
    public class VisitController : Controller
    {
        private readonly ApplicationDbContext _db;

        public VisitController(ApplicationDbContext db)
        {
            _db = db;
        }

        //INDEX
        public IActionResult Index()
        {
            var visitList = _db.Visit.ToList();

            foreach (var visit in visitList)
            {
                visit.Doctor = _db.Doctor.Find(visit.DoctorID);
                visit.Patient = _db.Patient.Find(visit.PatientID);
            }

            return View(visitList);
        }

        // SEARCH
        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Search(string searchTerm)
        {
            var searchVisitList = _db.Visit.Where(s => s.DoctorNotes!.Contains(searchTerm)).ToList();

            foreach (var visit in searchVisitList)
            {
                visit.Doctor = _db.Doctor.Find(visit.DoctorID);
                visit.Patient = _db.Patient.Find(visit.PatientID);
            }

            return View(searchVisitList);
        }


        // CREATE GET
        public IActionResult Create()
        {
            ViewData["DoctorID"] = new SelectList(_db.Doctor, "Id", "Name");
            ViewData["PatientID"] = new SelectList(_db.Patient, "Id", "Name");
            return View();
        }

        // CREATE POST
        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Create([Bind("Id,DoctorID,PatientID,DoctorNotes")] Visit visit)
        {
            if (visit.DoctorNotes == null)
            {
                ViewData["DoctorID"] = new SelectList(_db.Doctor, "Id", "Name");
                ViewData["PatientID"] = new SelectList(_db.Patient, "Id", "Name");
                return View(visit);
            }

            _db.Add(visit);
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

            var visit = _db.Visit.Find(id);

            if (visit == null)
            {
                return NotFound();
            }

            ViewData["DoctorID"] = new SelectList(_db.Doctor, "Id", "Name", visit.DoctorID);
            ViewData["PatientID"] = new SelectList(_db.Patient, "Id", "Name", visit.PatientID);
            return View(visit);
        }

        // EDIT POST
        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Edit(int id, [Bind("Id,DoctorID,PatientID,DoctorNotes")] Visit visit)
        {
            if (id != visit.Id)
            {
                return NotFound();
            }

            if (visit.DoctorNotes == null)
            {
                ViewData["DoctorID"] = new SelectList(_db.Doctor, "Id", "Name", visit.DoctorID);
                ViewData["PatientID"] = new SelectList(_db.Patient, "Id", "Name");
                return View(visit);
            }

            _db.Update(visit);
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

            var visitFromDb = _db.Visit.Find(id);

            if (visitFromDb == null)
            {
                return NotFound();
            }

            ViewData["DoctorName"] = _db.Doctor.Find(visitFromDb.DoctorID).Name;
            ViewData["PatientName"] = _db.Patient.Find(visitFromDb.PatientID).Name;
            return View(visitFromDb);
        }

        // DELETE POST
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public IActionResult DeletePOST(int id)
        {
            var visit = _db.Visit.Find(id);

            if (visit == null)
            {
                return NotFound();
            }

            _db.Visit.Remove(visit);
            _db.SaveChanges();
            return RedirectToAction("Index");
        }
    }
}
