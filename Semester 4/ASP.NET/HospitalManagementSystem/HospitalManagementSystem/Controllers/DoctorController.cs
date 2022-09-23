using Microsoft.AspNetCore.Mvc;
using HospitalManagementSystem.Data;
using HospitalManagementSystem.Models;

namespace HospitalManagementSystem.Controllers
{
    public class DoctorController : Controller
    {
        private readonly ApplicationDbContext _db;

        public DoctorController(ApplicationDbContext db) 
        {
            _db = db;
        }

        //INDEX
        public IActionResult Index()
        {
            var doctorsList = _db.Doctor.ToList();
            return View(doctorsList);
        }

        //SEARCH
        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Search(string searchTerm)
        {
            var searchDoctorsList = _db.Doctor.Where(s => s.Name!.Contains(searchTerm));
            return View(searchDoctorsList);
        }

        //CREATE GET
        public IActionResult Create() 
        {
            return View();
        }

        //CREATE POST
        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Create(Doctor doc)
        {
            if (ModelState.IsValid) 
            {
                _db.Doctor.Add(doc);
                _db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(doc);
        }


        //EDIT GET
        public IActionResult Edit(int? id) 
        {
            if (id==null || id==0) 
            {
                return NotFound();
            }

            var doctorFromDb = _db.Doctor.Find(id);

            if (doctorFromDb == null) 
            {
                return NotFound();
            }

            return View(doctorFromDb);
        }

        //EDIT POST
        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Edit(Doctor doc)
        {
            if (ModelState.IsValid)
            {
                _db.Doctor.Update(doc);
                _db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(doc);
        }

        //DELETE GET
        public IActionResult Delete(int? id)
        {
            if (id == null || id == 0)
            {
                return NotFound();
            }

            var doctorFromDb = _db.Doctor.Find(id);

            if (doctorFromDb == null)
            {
                return NotFound();
            }

            return View(doctorFromDb);
        }

        //DELETE POST
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public IActionResult DeletePOST(int? id)
        {
            var doc = _db.Doctor.Find(id);

            if (doc == null) 
            {
                return NotFound();
            }

            _db.Doctor.Remove(doc);
            _db.SaveChanges();
            return RedirectToAction("Index");
        }
    }
}
