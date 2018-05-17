
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Ortiz M
 */
public class NumeroAleatorio {
    
    public ArrayList<Float> congruencialMixto(int semillaX, int multiplicadorA, int constanteC, int moduloM){
        
        
        if(semillaX<=0 || multiplicadorA<=0 || constanteC<=0){
        
            JOptionPane.showMessageDialog(null, "Los valores deben ser positivos");
        
        }
        if(moduloM<semillaX || moduloM < multiplicadorA || moduloM <constanteC){
        
        JOptionPane.showMessageDialog(null, "Modulo M debe ser mayor a X,A y C ");
        
        }
    
        ArrayList<Float> nums = new ArrayList<Float>();
       
        int xAux=semillaX, aux=semillaX,i=0, aux2=-99999, aux3=-99999;
        do{
            try{
            xAux =(xAux*multiplicadorA + constanteC)%moduloM;
            if(xAux==aux3||i>=moduloM)break;
            if(i==0)aux2=xAux;
            else{ aux=aux2;
                  aux3=xAux;
            }
      
            if(xAux!=aux){
                float numReal =(float) xAux/moduloM;
                System.out.println(numReal);
                nums.add(new Float(numReal));
            }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "DIVISION ENTRE CERO\n"+e);
            }
         
            i++;
        }while(xAux!=aux);
        return nums;
    
    
    }
    
    public boolean pruebaPromedios(ArrayList<Float> numeros){
    
        double sumatoria=0;
        
        for (Iterator<Float> iterator = numeros.iterator(); iterator.hasNext();) {
            Float next = iterator.next();
           sumatoria=sumatoria+next;
            
        }
        System.out.println(numeros.size());
        double media = sumatoria/numeros.size();
        System.out.println("media: "+media);
        System.out.println("suma: "+sumatoria);
       double varianza=Math.sqrt((double)1/12);
        double Zo=(media-0.5)* Math.sqrt(numeros.size())/varianza;
        System.out.println("Zo"+Zo);
        if(Math.abs(Zo)<1.96){return true;}
        else return false;
    }
    
    public boolean pruebaFrecuencia(ArrayList<Float> numeros){
    
        int intervalo[] = new int[5];
        float FE = (float) numeros.size()/5;
        System.out.println("FE: "+FE);
                System.out.println("CANTIDAD: "+numeros.size());

        double chi2=0;
        for (Iterator<Float> iterator = numeros.iterator(); iterator.hasNext();) {
            Float next = iterator.next();
            
            if(next<0.2){intervalo[0]=intervalo[0]+1;}
            if(next>=0.2 && next<0.4){intervalo[1]=intervalo[1]+1;}
            if(next>=0.4 && next<0.6){intervalo[2]=intervalo[2]+1;}
            if(next>=0.6 && next<0.8){intervalo[3]=intervalo[3]+1;}
            if(next>=0.8 && next<1){intervalo[4]=intervalo[4]+1;}
        }
            for(int i=0;i<5;i++){
                System.out.println("INTERVALO "+i+ "  "+intervalo[i]);
            chi2 = chi2 +(Math.pow((intervalo[i] - FE),2)/FE);
            
            }
            
        
            System.out.println("VALOR DE CHI2= "+chi2);
            if(chi2<9.49)return true;
         
            
        return false;
    
    }
    
    
    public ArrayList<Float> congruencialMultiplicativo(int m, int a, int inicio){
        ArrayList<Float> nums = new ArrayList<Float>();
        String error="";
        int r=inicio,i=-9999, aux = inicio;
             do{
            try{
            if(i==1)
                inicio=r;
            r=(a*r)%m;
            if(i==1)aux=r;
            if(aux!=r){
            float numReal=(float)r/m;
            if(i<m){
            nums.add(new Float(numReal));
            }
            i++;
            }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se puede dividir entre 0\n"+e);
            }
        }while(aux!=r);

        System.out.println(error);
        return nums;
    }
    public boolean getdistancias(double vec[],int n,double alfa,int periodo)
	{
        
		double p[],foi,fei,a=0.3,b=0.7,x02,x0a;
		int N=periodo,fototal,ultimo=0;
		int hueco[];
		hueco=new int[periodo];
				
		p=new double[n+1]; 
		int aux=0,aux2=0;		
			for(int j=0;j<N;j++){
				if(vec[j]>=a && vec[j]<=b)
				{
					aux=j;
					ultimo=j;
					aux2=-1;
					do{
						aux2++;
						aux++;						
						if(aux>=N-1)
							break;
					}while(vec[aux]<a || vec[aux]>b);
					if(aux2>=n)
						aux2=n;
					hueco[aux2]++;
                                    
				}
				
			}
			if(ultimo!=N-1)
				hueco[N-1-ultimo]++;
			fototal=0;
			for(int i=0;i<=n;i++)
			{
				fototal+=hueco[i];
				p[i]=(b-a)*Math.pow((1-(b-a)),i);
			}
			p[n]=Math.pow((1-(b-a)),n);
			x02=0;                        
			for(int i=0;i<=n;i++)
			{
                            fei=fototal*p[i];
				x02+=(hueco[i]-fei)/fei;                                
			}
			TablaChi2 chi2 = new TablaChi2();
			x0a=chi2.getchi2().ObtenerChi(alfa, n);
		
			if(x02<x0a)
			{

                                return true;
			}
			else{

                                return false;
            }
			
		
	}
    public boolean getcorridas(double vec[],int n,double alfa,int periodo)
	{
		double fei[],x02=0,xan1;
		int R[],N=periodo,bin[],flag=0,aux=0,ultimo=0,Z=0;
		
		bin=new int[periodo];
		
		getbin(vec,bin,N);
		R=new int[N];
		fei=new double[N];
		for(int j=0;j<N;j++){
			flag=bin[j];
			
				aux=j;
				ultimo=j;
				Z=-1;
				do{
					Z++;
					aux++;						
					if(aux>=N-1)
						break;
				}while(bin[aux]!=flag);
				if(Z>=n)
					Z=n;
				R[Z]++;
                                
			
			
		}
		if(ultimo!=N-1)
			R[N-1-ultimo]++;
		double xx=0;
        if(N<=20){
		for(int i=0;i<N;i++)
		{
			if(i!=N-1){
                xx=(2*(N*(i*i)+3*i+1)-(i*i*i+3*i*i-i-4));
			fei[i]=xx/fact(i+3);
            }
			else
				fei[i]=2/fact(N);
		}
		      
		rodar(R,fei,N);
		
		for(int i=0;fei[i]!=0;i++)
		{
			
			x02+=Math.pow(R[i]-fei[i],2)/fei[i];
		}
        }
        else
            x02=Long.MAX_VALUE;
        TablaChi2 chi2 = new TablaChi2();
		xan1=chi2.ObtenerChi(alfa, n-1);
		if(x02<xan1)
        {
            return true;
        }
		else
        {
            return false;
        }
		
	}
	public void rodar(int a[],double fe[],int N)
	{
		for(int i=1;i<N;i++)
		{
			if(fe[i]<5)
			{
				for(int j=i-1;j>=0;j--)
				{
					if(fe[j]>0)
					{
						fe[j]+=fe[i];
						fe[i]=0;
						a[j]+=a[i];
						a[i]=0;
					}
						
				}
			}
		}
	}
	public long fact(int a)
	{
		long f=1;
		for(int i=2;i<=a;i++)
			f*=i;
		return f;
	}
	public void getbin(double a[],int b[],int N)
	{
		for(int i=0;i<N-1;i++)
		{
			if(a[i]<a[i+1])
				b[i]=0;
			else
				b[i]=1;
		}
		
	}
}

