using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace HospitalManagementSystem.Models
{
    public class Patient
    {
        [Key]
        public int Id { get; set; }


        public Doctor Doctor { get; set; }
        
        [ForeignKey("Doctor")]
        public int DoctorID { get; set; }


        [Required]
        public string? Name { get; set; }
    }
}
