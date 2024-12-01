<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Pronostico extends Model
{
    /** @use HasFactory<\Database\Factories\PronosticoFactory> */
    use HasFactory;

    protected $table = 'pronosticos';
    // Define qué campos pueden ser llenados masivamente
    protected $fillable = ['fecha', 'temperatura'];

    // Configura los casts para convertir temperatura a decimal
    protected $casts = [
        'temperatura' => 'float', // Cambiar a float o decimal
    ];
}
