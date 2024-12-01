<?php

namespace App\Http\Controllers;

use App\Models\Pronostico;
use Illuminate\Http\Request;

class PronosticoController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $pronosticos = Pronostico::all();

        return response()->json($pronosticos, 200);
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $pronostico = Pronostico::create($request->all());
        return response()->json($pronostico, 201);
    }

    /**
     * Display the specified resource.
     */
    public function show(string $fecha)
    {
        $pronostico = Pronostico::where('fecha', $fecha)->first();
        return response()->json($pronostico, 200);
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Pronostico $pronostico)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $fecha)
    {
        $pronostico = Pronostico::where('fecha', $fecha)->first();
        $pronostico->update($request->all());
        return response()->json($pronostico, 200);
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $fecha)
    {
        $pronostico = Pronostico::where('fecha', $fecha)->first();
        $pronostico->delete();
        return response()->json($pronostico, 204);
    }
}
