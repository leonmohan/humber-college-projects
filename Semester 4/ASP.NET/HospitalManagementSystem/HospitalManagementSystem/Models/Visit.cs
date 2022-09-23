using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace HospitalManagementSystem.Models
{
    public class Visit
    {
        [Key]
        public int Id { get; set; }

        [Required]
        public string DoctorNotes { get; set; }

        [ForeignKey("Doctor")]
        public int DoctorID { get; set; }

        public Doctor Doctor { get; set; }

        [ForeignKey("Patient")]
        public int PatientID { get; set; }

        public Patient Patient { get; set; }
    }
}
