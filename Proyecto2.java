import java.io.File;
import java.util.Scanner;

public class Proyecto2 {
	//Función que realiza la lectura de la tabla periódica
	public static void leer(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we){
		//Impresión títulos de las columnas:
		System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-29s %-19s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
		//Ciclo que recorre todos los elementos de los arrays: IMPRESIÓN DE LA TABLA
		for(int i = 0;i<n.length;i++) {
			System.out.printf("%-15s %-20s %-15s %-20s %-20s %-20s %-15s %-15s %-16s %-15s %-15s %-15s %-15s %-15s %-15s %-28s %-25s %-20s %-14s %-20s %-20s %-25s %-25s %-28s %-20s %-20s %-20s %-24s ",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);
			System.out.println();
		}
		System.out.println();
	}
	//1.Función de busqueda por SÍMBOLO
	public static void busquedaSy(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false; //Bandera que identifica la existencia de la opción de filtrado (no recorre el ciclo, sale al if con el mensaje ERROR)
		int repe = 1;//Bandera que permite imprimir los títulos de los elementos solo una vez 
		for(int i = 0;i<118;i++) { //Ciclo que recorre la columna
			if( a[i].equals(elec)) { //Evaluación del elemento escogido. Imprime los elementos que coincidan con la elección del usuario (función elec). 
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}
				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);
				System.out.println();
				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe ese simbolo");
		}
	}
	//2.Función de búsqueda por ELEMENTO 
	public static void busquedaElemento(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( b[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}
				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);
				System.out.println();
				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe ese elemento");
		}
	}
	//3.Función de búsqueda por NÚMERO ATÓMICO
	public static void busquedaNAto(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( c[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);

				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe ese número atómico");
		}
		System.out.println();
	}
	//4.Función de búsqueda por MASA ATÓMICA
	public static void busquedaMa(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( d[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				
				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);

				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe esa masa atomica");
		}
		System.out.println();
	}
	//5.Función de búsqueda por NÚMERO DE NEUTRONES 
	public static void busquedaNumNeutrones(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( e[i].equals(elec)) {
				if(repe==1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}
				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);
				existe=true;
			}
		}
		if(existe == false) {
			System.out.println("No existe ese número de neutrones");
		}
		System.out.println ();
	}
	//6.Función de búsqueda por NÚMERO DE PROTONES
	public static void busquedaProt(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( f[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);

				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe ese número de protones");
		}
		System.out.println();
	}
	//7.Función de búsqueda por NÚMERO DE ELECTRONES
	public static void busquedaNe(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( g[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				
				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);
				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe ese numero de electrones");
		}
		System.out.println();
	}
	//8.Función de búsqueda por PERIODO 
	public static void busquedaPeriodo(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( h[i].equals(elec)) {
				if(repe==1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}
				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);
				existe=true;
			}
		}
		if(existe == false) {
			System.out.println("No existe ese periodo");
		}
		System.out.println ();
	}
	//9.Función de búsqueda por GRUPO
	public static void busquedaG(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( is[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				
				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);
				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe ese grupo");
		}
		System.out.println();
	}
	//10.Función de búsqueda por FASE
	public static void busquedaFase(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( j[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);

				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe ese número de protones");
		}
		System.out.println();
	}
	//11.Función de búsqueda por RADIACTIVIDAD
	public static void busquedaRa(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( k[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}
				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);

				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe esa radioactividad");
		}
		System.out.println();
	}
	//12.Función de búsqueda: NATURAL
	public static void busquedaNatural(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( l[i].equals(elec)) {
				if(repe==1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}
				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);
				existe=true;
			}
		}
		if(existe == false) {
			System.out.println("No existe ese elemento natural");
		}
		System.out.println ();
	}
	//13.Función de búsqueda: METAL
	public static void busquedaMetal(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( m[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);

				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe ese número de protones");
		}
		System.out.println();
	}
	//14.Función de búsqueda: NO METAL
	public static void busquedaNm(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( n[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);

				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe esa opcion");
		}
		System.out.println();
	}
	//15.Función de búsqueda: METALLOIDE
	public static void busquedaMll(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( ñ[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);

				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe esa opcion");
		}
		System.out.println();
	}
	//16.Función de búsqueda por TIPO
	public static void busquedaTipo(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( o[i].equals(elec)) {
				if(repe==1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}
				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);
				existe=true;
			}
		}
		if(existe == false) {
			System.out.println("No existe esa opción en el tipo");
		}
		System.out.println ();
	}
	//17.Función de búsqueda por RADIO ATÓMICO
	public static void busquedaAr(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( p[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);

				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe esa opcion");
		}
		System.out.println();
	}
	//18.Función de búsqueda por ELECTRO-NEGATIVIDAD
	public static void busquedaEn(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( q[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);

				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe esa opcion");
		}
		System.out.println();
	}
	//19.Función de búsqueda de la PRIMERA IONIZACIÓN
	public static void busquedaIo(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( r[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				
				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);

				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe esa primera ionizacion");
		}
		System.out.println();
	}
	//20.Función de búsqueda por DENSIDAD
	public static void busquedaDensidad(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( s[i].equals(elec)) {
				if(repe==1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}
				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);
				existe=true;
			}
		}
		if(existe == false) {
			System.out.println("No existe esa densidad");
		}
		System.out.println ();
	}
	//21.Función de búsqueda por PUNTO DE FUSIÓN
	public static void busquedaPFusi(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( t[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);

				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe ese número de protones");
		}
		System.out.println();
	}
	//22.Función de búsqueda por PUNDO DE EBULLICIÓN
	public static void busquedaPe(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( u[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);

				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe ese punto de ebullicion");
		}
		System.out.println();
	}
	//23.Función de búsqueda por NÚMERO DE ISÓTOPOS 
	public static void busquedaIsotopos(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( v[i].equals(elec)) {
				if(repe==1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}
				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);
				existe=true;
			}
		}
		if(existe == false) {
			System.out.println("No existe ese isótopo");
		}
		System.out.println ();
	}
	//24.Función de búsqueda por DESCUBRIDOR
	public static void busquedaDes(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( w[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);

				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No se encuentran elementos en base a ese descubrimiento.");
		}
		System.out.println();
	}
	//25.Función de búsqueda por AÑO
	public static void busquedaAñ(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( y[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);

				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No se encuentra por ese año");
		}
		System.out.println();
	}
	//26.Función de búsqueda por CALOR ESPECÍFICO
	public static void busquedaCalor(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( z[i].equals(elec)) {
				if(repe==1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}
				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);
				existe=true;
			}
		}
		if(existe == false) {
			System.out.println("No existe ese calor específico");
		}
		System.out.println ();
	}
	//27.Función de búsqueda por NÚMERO DE CAPAS
	public static void busquedaNShe(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( qa[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);

				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe ese número de shells");
		}
		System.out.println();
	}
	//28.Función de búsqueda por NÚMERO DE VALENCIA
	public static void busquedaNv(String []a,String []b,String []c,String []d,String []e,String []f,String []g,String []h,String []is,String []j,String []k,String []l,String []m,String []n,String []ñ,String []o,String []p,String []q,String []r,String []s,String []t,String []u,String []v,String []w,String []y,String []z,String []qa,String []we,String elec){
		boolean existe = false;
		int repe = 1;
		for(int i = 0;i<118;i++) {
			if( we[i].equals(elec)) {
				if(repe == 1) {
					System.out.printf("%-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n" ,"Symbol","Element","AtomicNumber","AtomicMass","NumberofNeutrons","NumberofProtons","NumberofElectrons","Period","group","Phase","Radioactive","Natural","Metal","Nonmetal","Metalloid","Type","AtomicRadius","Electronegativity","FirstIonization","Density","MeltingPoint","BoilingPoint","NumberOfIsotopes","Discoverer","Year","SpecificHeat","NumberofShells","NumberofValence");
					repe++;
				}				System.out.printf(" %-15s %-15s %-18s %-15s %-20s %-20s %-20s %-16s %-16s %-12s %-17s %-16s %-14s %-15s %-18s %-25s %-20s %-20s %-20s %-20s %-20s %-25s %-25s %-20s %-17s %-20s %-19s %-20s \n",a[i],b[i],c[i],d[i],e[i],f[i],g[i],h[i],is[i],j[i],k[i],l[i],m[i],n[i],ñ[i],o[i],p[i],q[i],r[i],s[i],t[i],u[i],v[i],w[i],y[i],z[i],qa[i],we[i]);

				existe = true;
			}
		}
		if(existe == false) {
			System.out.println("No existe esa opcion");
		}
		System.out.println();
	}



	public static void main(String[] args) {
		//Declaración de variables iniciales:
		boolean salir = false; //Bandera que permite salir de los menús cuando así se requiera, y finalizar el programa
		int menu = 0; //Guarda la elección de usuario respecto al primer menú: leer, filtrar o salir. 
		File fichero = new File ("Tabla5.csv"); //Fichero donde se almacena la tabla periódica
		//Declaración de las variables Scanner 
		Scanner sc = null; //Scanner Menu
		Scanner sc1 = null; //Scanner Menu2 > Switch Case (filtrar)
		//Creacción de los arrays donde se guardará cada columna de la Tabla Periódica
		String []n = new String [118];
		String []y = new String [28];
		String []Symbol = new String [118];	
		String []Element = new String [118];	
		String []AtomicNumber = new String [118];	
		String []AtomicMass	= new String [118];
		String []NumberofNeutrons = new String [118];	
		String []NumberofProtons	 = new String [118];
		String []NumberofElectrons	= new String [118];
		String []Period = new String [118];
		String []Group	= new String [118];
		String []Phase	= new String [118];
		String []Radioactive	= new String [118];
		String []Natural	= new String [118];
		String []Metal	= new String [118];
		String []Nonmetal	= new String [118];
		String []Metalloid	= new String [118];
		String []Type	= new String [118];
		String []AtomicRadius= new String [118];	
		String []Electronegativity	= new String [118];
		String []FirstIonization	= new String [118];
		String []Density	= new String [118];
		String []MeltingPoint	= new String [118];
		String []BoilingPoint	= new String [118];
		String []NumberOfIsotopes	= new String [118];
		String []Discoverer	= new String [118];
		String []Year	= new String [118];
		String []SpecificHeat= new String [118];	
		String []NumberofShells= new String [118];
		String []NumberofValence= new String [118];
		//Declaración de variables de ejecución:
		int x = 0; //Inicializa los Strings en 0
		String a = " ";/*Variable usada en el Menu2 para almacenar la última opción de filtrado que escoga el usuario. 
		Filtrados por columnas. Ejemplo: Filtrado por símbolo H (a=H).*/
		
		//Estrucura TRY-CATCH sobre el fichero de la Tabla Periodica
		try {
			sc = new Scanner(fichero);     // Configura para leer de fichero
			//Bucle WHILE que instancia en los arrays (previamente creados), los elementos que guarda el fichero
			while(sc.hasNextLine()) {      // Se lee línea a línea

				n[x]= sc.nextLine(); // Guardar en String
				y = n[x].split(",");
				Symbol[x] = y[0];
				Element[x] = y[1];	
				AtomicNumber[x] = y[2];	
				AtomicMass[x]	= y[3];
				NumberofNeutrons[x] = y[4];	
				NumberofProtons[x]	 = y[5];
				NumberofElectrons[x]	= y[6];
				Period[x]	= y[7];
				Group[x] = y[8];
				Phase[x]	= y[9];
				Radioactive[x]	= y[10];
				Natural[x]	= y[11];
				Metal[x]	= y[12];
				Nonmetal[x]	= y[13];
				Metalloid[x]	= y[14];
				Type[x]	= y[15];	
				AtomicRadius[x]	= y[16];
				Electronegativity[x]	= y[17];
				FirstIonization[x]= y[18];
				Density[x]	= y[19];
				MeltingPoint[x]	= y[20];
				BoilingPoint[x]	= y[21];
				NumberOfIsotopes[x]	= y[22];
				Discoverer[x]	= y[23];
				Year[x]  = y[24];	
				SpecificHeat[x]= y[25];
				NumberofShells[x] = y[26];
				NumberofValence[x] = y[27];

				x++;
			}
		} catch(Exception ex) { System.out.println("ERROR: \n"+ ex.getMessage()); }

		System.out.println("Bienvenido a la tabla periodica.");
		
		//Bucle que ejecuta el programa siempre y cuando el usuario no cierre: OPCIÓN [3] 
		while(salir==false) {
			//Declaración de variable de ejecución:
			boolean p = true; //Bandera que permite salir de cada opción
			//Bucle que ejecuta el programa tantas veces como el usuario desee: OPCIONES [1] y OPCIÓN [2]
			while(p==true) {
				//Embellecedores de programa (opciones de usuario)
				System.out.println("Seleccione [1]Leer base da datos.");
				System.out.println("Seleccione [2]Para buscar.");
				System.out.println("Seleccione [3]Cerrar programa.");
				
				sc = new Scanner (System.in);//Habilitar teclado
				while(!sc.hasNextInt()) { //Evaluación del tipo de variable introducida por el usuario
					System.out.println("ERROR");
					sc.next();
				}

				menu = sc.nextInt(); //Lectura de la opción 
				
				//Switch de evaluación de la opción escogida en el menú inicial
				switch(menu) {

				case 1 : //Leer fichero. Llamada a la función que ejecuta la lectura. 
					leer(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence);
					p=false;
					break;
				case 2: 
					//Declaración de variables de ejecución:
					boolean salir2 = true; //Bandera que permite finalizar el segundo switch (filtrados-opción 29)
					int menu2 = 0; //Guarda la opción de filtrado para usarla en el Switch-Case (funciones)
					//While que permite llevar a cabo filtrados en la tabla periodica para imprimir el elemento que desee el usuario
					while(salir2 == true) {
						//Embellecedor de programa: Imprime las opciones de filtrado de las que dispone el programa. 
						System.out.printf(" %-25s %-25s %-25s %n %-25s %-25s %-25s %n %-25s %-25s %-25s %n %-25s %-25s %-25s %n %-25s %-25s %-25s %n %-25s %-25s %-25s %n %-25s %-25s %-25s %n %-25s %-25s %-25s %n %-25s %-25s %-25s %n %-25s %-25s \n",
								"[1]Symbol","[2]Element","[3]AtomicNumber","[4]AtomicMass","[5]NumberofNeutrons","[6]NumberofProtons","[7]NumberofElectrons","[8]Period","[9]Group","[10]Phase","[11]Radioactive",
								"[12]Natural","[13]Metal","[14]Nonmetal","[15]Metalloid","[16]Type","[17]AtomicRadius","[18]Electronegativity","[19]FirstIonization","[20]Density","[21]MeltingPoint","[22]BoilingPoint",
								"[23]NumberOfIsotopes","[24]Discoverer","[25]Year","[26]SpecificHeat","[27]NumberofShells","[28]NumberofValence","[29]Salir");
						System.out.println();
						System.out.println("Elija:");
						sc = new Scanner (System.in); //Habilitar teclado

						while(!sc.hasNextInt()) { //Evaluación del tipo de variable introducida por el usuario 
							System.out.println("ERROR");
							sc.next();
						}

						menu2 = sc.nextInt(); //Lectura de la Opción
						//Switch de evaluación de la opción escogida en el menú por filtrados
						switch(menu2) {
						case 1: //Llamada a la función de busqueda por SÍMBOLO
							sc1 = new Scanner (System.in); 
							System.out.println("Imprima un simbolo:");
							System.out.print("(");
							for(int xy = 0;xy<Symbol.length;xy++) { //Ciclo de impresión del array que almacena los símbolos. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(Symbol[xy]+","); 
								}else {
									System.out.print(Symbol[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaSy(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 2: //Llamada a la función de búsqueda por ELEMENTO
							sc1 = new Scanner (System.in);
							System.out.println("Imprima un elemento:");
							System.out.print("(");
							for(int xy = 0;xy<Element.length;xy++) { //Ciclo de impresión del array que almacena los elementos. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(Element[xy]+",");
								}else {
									System.out.print(Element[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaElemento(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 3: //Llamada a la función de búsqueda por NÚMERO ATÓMICO
							sc1 = new Scanner (System.in);
							System.out.println("Imprima un numero atomico:");
							System.out.print("(");
							for(int xy = 0;xy<AtomicNumber.length;xy++) { //Ciclo de impresión del array que almacena los números atómicos. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(AtomicNumber[xy]+",");
								}else {
									System.out.print(AtomicNumber[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaNAto(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 4: //Llamada a la función de búsqueda por MASA ATÓMICA
							sc1 = new Scanner (System.in);
							System.out.println("Imprima masa atomica:");
							System.out.print("(");
							for(int xy = 0;xy<AtomicMass.length;xy++) { //Ciclo de impresión del array que almacena la masa atómica. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(AtomicMass[xy]+",");
								}else {
									System.out.print(AtomicMass[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaMa(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 5: //Llamada a la función de búsqueda por NÚMERO DE NEUTRONES
							sc1 = new Scanner (System.in);
							System.out.println("Imprima un numero de neutrones:");
							System.out.print("(");
							for(int xy = 0;xy<NumberofNeutrons.length;xy++) { //Ciclo de impresión del array que almacena el número de neutrones. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(NumberofNeutrons[xy]+",");
								}else {
									System.out.print(NumberofNeutrons[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaNumNeutrones(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 6: //Llamada a la función de búsqueda por NÚMERO DE PROTONES
							sc1 = new Scanner (System.in);
							System.out.println("Imprima un numero de protones:");
							System.out.print("(");
							for(int xy = 0;xy<NumberofProtons.length;xy++) { //Ciclo de impresión del array que almacena el número de protones. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(NumberofProtons[xy]+",");
								}else {
									System.out.print(NumberofProtons[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaProt(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 7: //Llamada a la función de búsqueda por NÚMERO DE ELECTRONES
							sc1 = new Scanner (System.in);
							System.out.println("Imprima un numero de electrones:");
							System.out.print("(");
							for(int xy = 0;xy<NumberofElectrons.length;xy++) { //Ciclo de impresión del array que almacena el número de electrones. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(NumberofElectrons[xy]+",");
								}else {
									System.out.print(NumberofElectrons[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaNe(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 8: //Llamada a la función de búsqueda por PERIODO
							sc1 = new Scanner (System.in);
							System.out.println("Imprima un periodo:");
							System.out.print("(");
							for(int xy = 0;xy<Period.length;xy++) { //Ciclo de impresión del array que almacena el periodo. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(Period[xy]+",");
								}else {
									System.out.print(Period[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaPeriodo(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 9: //Llamada a la función de búsqueda por GRUPO
							sc1 = new Scanner (System.in);
							System.out.println("Imprima un grupo:");
							System.out.print("(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,x) \n");//Impresión de opciónes de filtrado por grupo. Usuario ve las opciones de filtrado.				
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaG(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 10: //Llamada a la función de búsqueda por FASE
							sc1 = new Scanner (System.in);
							System.out.println("Imprima su fase:");
							System.out.print("(");
							for(int xy = 0;xy<Phase.length;xy++) { //Ciclo de impresión del array que almacena la fase. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(Phase[xy]+",");
								}else {
									System.out.print(Phase[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaFase(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 11: //Llamada a la función de búsqueda por RADIACTIVIDAD
							sc1 = new Scanner (System.in);
							System.out.println("Imprima su radioactividad (yes o no o x): \n"); //Impresión de opciones de filtrado por radiactividad. 
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaRa(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 12: //Llamada a la función de búsqueda: NATURAL
							sc1 = new Scanner (System.in);
							System.out.println("Imprima si es natural (yes o no o x): \n"); //Impresión de opciones de filtrado por elementos naturales. 
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaNatural(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 13: //Llamada a la función de búsqueda: METAL
							sc1 = new Scanner (System.in);
							System.out.println("Imprima si es metal (yes o no o x): \n"); //Impresión de opciones de filtrado por metales. 
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaMetal(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 14: //Llamada a la función de búsqueda: NO METAL
							sc1 = new Scanner (System.in);
							System.out.println("Imprima si es no-metal (yes o no o x):\n"); //Impresión de opciones de filtrado por no metales. 
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaNm(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 15: //Llamada a la función de búsqueda: METALLOIDE
							sc1 = new Scanner (System.in);
							System.out.println("Imprima si es metalloide (yes o no o x): \n"); //Impresión de opciones de filtrado por metalloides. 
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaMll(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 16: //Llamada a la función de búsqueda por TIPO
							sc1 = new Scanner (System.in);
							//Impresión de opciones para filtrar por tipo:
							System.out.println("Imprima el tipo (Metal,Nonmetal,Metalloid,Halogen,Noble Gas,Transition Metal,Alkali Metal,Lanthanide,Actinide,Transactinide): \n");
							a = sc1.nextLine(); //Lectura de la Opción
							//Función:
							busquedaTipo(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 17: //Llamada a la función de búsqueda por RADIO ATÓMICO
							sc1 = new Scanner (System.in);
							System.out.println("Imprima  su radio atomico:");
							System.out.print("(");
							for(int xy = 0;xy<AtomicRadius.length;xy++) { //Bucle de impresión del array que almacena el radio atómico. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(AtomicRadius[xy]+",");
								}else {
									System.out.print(AtomicRadius[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaAr(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 18: //Llamada a la función de búsqueda por ELECTRO-NEGATIVIDAD
							sc1 = new Scanner (System.in);
							System.out.println("Imprima  su electro-negatividad:");
							System.out.print("(");
							for(int xy = 0;xy<Electronegativity.length;xy++) { //Bucle de impresión del array que almacena la electro-negatividad. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(Electronegativity[xy]+",");
								}else {
									System.out.print(Electronegativity[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaEn(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 19: //Llamada a la función de búsqueda de la PRIMERA IONIZACIÓN
							sc1 = new Scanner (System.in);
							System.out.println("Imprima  su primera ionizacion:");
							System.out.print("(");
							for(int xy = 0;xy<FirstIonization.length;xy++) { //Bucle de impresión del array que almacena la ionización. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(FirstIonization[xy]+",");
								}else {
									System.out.print(FirstIonization[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaIo(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 20: //Llamada a la función de búsqueda por DENSIDAD
							sc1 = new Scanner (System.in);
							System.out.println("Imprima su densidad:");
							System.out.print("(");
							for(int xy = 0;xy<Density.length;xy++) { //Bucle de impresión del array que almacena la densidad. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(Density[xy]+",");
								}else {
									System.out.print(Density[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaDensidad(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 21: //Llamada a la función de búsqueda por PUNTO DE FUSIÓN
							sc1 = new Scanner (System.in);
							System.out.println("Imprima su punto de fusion:");
							System.out.print("(");
							for(int xy = 0;xy<MeltingPoint.length;xy++) { //Bucle de impresión del array que almacena el punto de fusión. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(MeltingPoint[xy]+",");
								}else {
									System.out.print(MeltingPoint[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaPFusi(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);

							break;
						case 22: //Llamada a la función de búsqueda por PUNDO DE EBULLICIÓN
							sc1 = new Scanner (System.in);
							System.out.println("Imprima su punto de ebullicion:");
							System.out.print("(");
							for(int xy = 0;xy<BoilingPoint.length;xy++) { //Bucle de impresión del array que almacena el punto de ebullición. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(BoilingPoint[xy]+",");
								}else {
									System.out.print(BoilingPoint[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaPe(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 23: //Llamada a la función de búsqueda por NÚMERO DE ISÓTOPOS
							sc1 = new Scanner (System.in);
							System.out.println("Imprima su numero de isotopos:");
							System.out.print("(");
							for(int xy = 0;xy<NumberOfIsotopes.length;xy++) { //Bucle de impresión del array que almacena el número de isótopos. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(NumberOfIsotopes[xy]+",");
								}else {
									System.out.print(NumberOfIsotopes[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaIsotopos(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 24: //Llamada a la función de búsqueda por DESCUBRIDOR
							sc1 = new Scanner (System.in);
							System.out.println("Imprima su descubridor:");
							System.out.print("(");
							for(int xy = 0;xy<Discoverer.length;xy++) { //Bucle de impresión del array que almacena los descubridores de elmentos. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(Discoverer[xy]+",");
								}else {
									System.out.print(Discoverer[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.nextLine(); //Lectura de la Opción
							//Función:
							busquedaDes(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 25: //Llamada a la función de búsqueda por AÑO
							sc1 = new Scanner (System.in);
							System.out.println("Imprima su año:");
							System.out.print("(");
							for(int xy = 0;xy<Year.length;xy++) { //Bucle de impresión del array que almacena el año. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(Year[xy]+",");
								}else {
									System.out.print(Year[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaAñ(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 26: //Llamada a la función de búsqueda por CALOR ESPECÍFICO
							sc1 = new Scanner (System.in);
							System.out.println("Imprima su calor especifico:");
							System.out.print("(");
							for(int xy = 0;xy<SpecificHeat.length;xy++) { //Bucle de impresión del array que almacena el calor específico. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(SpecificHeat[xy]+",");
								}else {
									System.out.print(SpecificHeat[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaCalor(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 27: //Llamada a la función de búsqueda por NÚMERO DE CAPAS
							sc1 = null;
							sc1 = new Scanner (System.in);
							System.out.println("Imprima su numero de capas:");
							System.out.print("(");
							for(int xy = 0;xy<NumberofShells.length;xy++) { //Bucle de impresión del array que almacena el número de capas. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(NumberofShells[xy]+",");
								}else {
									System.out.print(NumberofShells[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaNShe(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 28: //Llamada a la función de búsqueda por NÚMERO DE VALENCIA
							sc1 = new Scanner (System.in);
							System.out.println("Imprima su numero de valencia:");
							System.out.print("(");
							for(int xy = 0;xy<NumberofValence.length;xy++) { //Bucle de impresión del array que almacena el número de valencia. Usuario ve las opciones de filtrado.
								if(xy<117) { //If de impresión de comas hasta el penúltimo elemento
									System.out.print(NumberofValence[xy]+",");
								}else {
									System.out.print(NumberofValence[xy]);
								}
							}
							System.out.print(") \n");
							a = sc1.next(); //Lectura de la Opción
							//Función:
							busquedaNv(Symbol,Element,AtomicNumber,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence,a);
							break;
						case 29:
							System.out.println("saliendo...");
							salir2 = false; 
							break;
						default:
							System.out.println("ERROR");
							break;
						}//menu2
					}//salir2
					p=false;
					break;

				case 3: //Opción 3: Salir de programa
					p=false;
					salir = true;
					System.out.println("Programa terminado...");
					break;
				default:
					System.out.println("ERROR \n");
					break;
				}//switch menu
			}//while p
		}//salir

	}//main	
}//clase