using System;

namespace ComplexAlgebra
{
    /// <summary>
    /// A type for representing Complex numbers.
    /// </summary>
    ///
    /// TODO: Model Complex numbers in an object-oriented way and implement this class.
    /// TODO: In other words, you must provide a means for:
    /// TODO: * instantiating complex numbers
    /// TODO: * accessing a complex number's real, and imaginary parts
    /// TODO: * accessing a complex number's modulus, and phase
    /// TODO: * complementing a complex number
    /// TODO: * summing up or subtracting two complex numbers
    /// TODO: * representing a complex number as a string or the form Re +/- iIm
    /// TODO:     - e.g. via the ToString() method
    /// TODO: * checking whether two complex numbers are equal or not
    /// TODO:     - e.g. via the Equals(object) method
    public class Complex
    {
        public double Real { get;}
        public double Imaginary { get;}

        public double Modulus
        {
            get => Math.Sqrt(Real * Real + Imaginary * Imaginary);
        }

        public double Phase
        {
            get => Math.Atan2(Imaginary, Real);
        }

        public Complex(double real, double imm)
        {
            Real = real;
            Imaginary = imm;            
        }

        public Complex Complement() => new Complex(Real, -Imaginary);
        public Complex Plus(Complex a) => new Complex(Real + a.Real, Imaginary + a.Imaginary);
        public Complex Minus(Complex a) => new Complex(Real - a.Real, Imaginary - a.Imaginary);
        public override string ToString() => $"{Real} {(Imaginary > 0 ? "+" : "-")} i {Math.Abs(Imaginary)}";
        public override bool Equals(Object a)
        {
            if (a.GetType() == this.GetType())
            {
                Complex b = (Complex)a;

                if (Real == b.Real && Imaginary == b.Imaginary)
                {
                    return true;
                }
            }
            return false; 
        }
        public override int GetHashCode() => HashCode.Combine(Real, Imaginary);
    }
}