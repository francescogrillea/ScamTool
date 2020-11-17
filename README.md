# ScamTool
Pagare le bollette di casa a Pisa diventa sempre più difficile, per questo motivo è stato introdotto questo tool dotato di interfaccia grafica che permette la divisione in modo proporziato della penale di ciascuna delle bollette pagate in ritardo tra i coinquilini che non hanno rispettato la data di scadenza.  

## Funzione di Calcolo  
Sia *quota[i]* la quota del coinquilino *i*; *days[i]* il numero di giorni ritardo del coinquilino *i*; *totGiorni* la somma dei singoli *days[i]*; *totImporto* l'importo della penale. Per calcolare il valore di *quota[i]* occorre svolgere due proporzioni:  
`days[i] : totGiorni = x : 100` e `x : 100 = quota[i] : totImporto`  
Il che si può riscrivere nella forma `(((days[i] * 100) / totGiorni) * totImporto) / 100`  

## Screenshot  
![Screenshot](/Screenshots/screenshot.PNG?raw=true)
