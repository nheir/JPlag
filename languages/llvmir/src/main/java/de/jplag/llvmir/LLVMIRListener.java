package de.jplag.llvmir;

import static de.jplag.llvmir.LLVMIRTokenType.*;
import static de.jplag.llvmir.grammar.LLVMIRParser.AShrExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.AShrInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.AddExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.AddInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.AddrSpaceCastExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.AddrSpaceCastInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.AllocaInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.AndExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.AndInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.ArrayConstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.AtomicOrderingContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.AtomicRMWInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.BasicBlockContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.BitCastExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.BitCastInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.BrTermContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.CallBrTermContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.CallInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.Case_Context;
import static de.jplag.llvmir.grammar.LLVMIRParser.CatchPadInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.CatchRetTermContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.CatchSwitchTermContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.ClauseContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.CleanupPadInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.CleanupRetTermContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.CmpXchgInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.CondBrTermContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.ExtractElementExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.ExtractElementInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.ExtractValueInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FAddInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FCmpExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FCmpInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FDivInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FMulInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FRemInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FSubInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FenceInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FpExtExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FpExtInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FpToSiExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FpToSiInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FpToUiExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FpToUiInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FpTruncExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FpTruncInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FuncBodyContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FuncDeclContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.FuncDefContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.GetElementPtrExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.GetElementPtrInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.GlobalDeclContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.GlobalDefContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.ICmpExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.ICmpInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.IndirectBrTermContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.InlineAsmContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.InsertElementExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.InsertElementInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.InsertValueInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.IntToPtrExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.IntToPtrInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.InvokeTermContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.LShrExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.LShrInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.LandingPadInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.LoadInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.ModuleAsmContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.MulExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.MulInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.OrExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.OrInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.PhiInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.PtrToIntExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.PtrToIntInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.ResumeTermContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.RetTermContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.SDivInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.SExtExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.SExtInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.SRemInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.SelectExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.SelectInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.ShlExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.ShlInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.ShuffleVectorExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.ShuffleVectorInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.SiToFpExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.SiToFpInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.SourceFilenameContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.StoreInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.StructConstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.SubExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.SubInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.SwitchTermContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.TruncExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.TruncInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.TypeDefContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.UDivInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.URemInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.UiToFpExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.UiToFpInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.VaargInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.VectorConstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.XorExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.XorInstContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.ZExtExprContext;
import static de.jplag.llvmir.grammar.LLVMIRParser.ZExtInstContext;

import de.jplag.antlr.AbstractAntlrListener;

/**
 * Extracts tokens from the ANTLR parse tree. The token abstraction includes nesting tokens for functions and basic
 * blocks and separate tokens for different elements. These include binary and bitwise instructions, memory operations,
 * terminator instructions, conversions, global variables, type definitions, constants, and others.
 */
public class LLVMIRListener extends AbstractAntlrListener {

    /**
     * New instance
     */
    public LLVMIRListener() {
        super();

        visit(SourceFilenameContext.class).map(FILENAME);
        visit(ModuleAsmContext.class).map(ASSEMBLY);
        visit(TypeDefContext.class).map(TYPE_DEFINITION);
        visit(GlobalDeclContext.class).map(GLOBAL_VARIABLE);
        visit(GlobalDefContext.class).map(GLOBAL_VARIABLE);
        visit(FuncDeclContext.class).map(FUNCTION_DECLARATION);
        visit(FuncDefContext.class).map(FUNCTION_DEFINITION);
        visit(FuncBodyContext.class).map(FUNCTION_BODY_BEGIN, FUNCTION_BODY_END);
        visit(BasicBlockContext.class).map(BASIC_BLOCK_BEGIN, BASIC_BLOCK_END);
        visit(RetTermContext.class).map(RETURN);
        visit(BrTermContext.class).map(BRANCH);
        visit(CondBrTermContext.class).map(CONDITIONAL_BRANCH);
        visit(SwitchTermContext.class).map(SWITCH);
        visit(IndirectBrTermContext.class).map(BRANCH);
        visit(ResumeTermContext.class).map(RESUME);
        visit(CatchRetTermContext.class).map(CATCH_RETURN);
        visit(CleanupRetTermContext.class).map(CLEAN_UP_RETURN);
        visit(InvokeTermContext.class).map(INVOKE);
        visit(CallBrTermContext.class).map(CALL_BRANCH);
        visit(CatchSwitchTermContext.class).map(CATCH_SWITCH);
        visit(Case_Context.class).map(CASE);
        visit(StructConstContext.class).map(STRUCTURE);
        visit(ArrayConstContext.class).map(ARRAY);
        visit(VectorConstContext.class).map(VECTOR);
        visit(InlineAsmContext.class).map(ASSEMBLY);
        visit(BitCastExprContext.class).map(BITCAST);
        visit(GetElementPtrExprContext.class).map(GET_ELEMENT_POINTER);
        visit(AddrSpaceCastExprContext.class).map(CONVERSION);
        visit(IntToPtrExprContext.class).map(CONVERSION);
        visit(ICmpExprContext.class).map(COMPARISON);
        visit(FCmpExprContext.class).map(COMPARISON);
        visit(SelectExprContext.class).map(SELECT);
        visit(TruncExprContext.class).map(CONVERSION);
        visit(ZExtExprContext.class).map(CONVERSION);
        visit(SExtExprContext.class).map(CONVERSION);
        visit(FpTruncExprContext.class).map(CONVERSION);
        visit(FpExtExprContext.class).map(CONVERSION);
        visit(FpToUiExprContext.class).map(CONVERSION);
        visit(FpToSiExprContext.class).map(CONVERSION);
        visit(UiToFpExprContext.class).map(CONVERSION);
        visit(SiToFpExprContext.class).map(CONVERSION);
        visit(PtrToIntExprContext.class).map(CONVERSION);
        visit(ExtractElementExprContext.class).map(EXTRACT_ELEMENT);
        visit(InsertElementExprContext.class).map(INSERT_ELEMENT);
        visit(ShuffleVectorExprContext.class).map(SHUFFLE_VECTOR);
        visit(ShlExprContext.class).map(SHIFT);
        visit(LShrExprContext.class).map(SHIFT);
        visit(AShrExprContext.class).map(SHIFT);
        visit(AndExprContext.class).map(AND);
        visit(OrExprContext.class).map(OR);
        visit(XorExprContext.class).map(XOR);
        visit(AddExprContext.class).map(ADDITION);
        visit(SubExprContext.class).map(SUBTRACTION);
        visit(MulExprContext.class).map(MULTIPLICATION);
        visit(StoreInstContext.class).map(STORE);
        visit(FenceInstContext.class).map(FENCE);
        visit(AddInstContext.class).map(ADDITION);
        visit(FAddInstContext.class).map(ADDITION);
        visit(SubInstContext.class).map(SUBTRACTION);
        visit(FSubInstContext.class).map(SUBTRACTION);
        visit(MulInstContext.class).map(MULTIPLICATION);
        visit(FMulInstContext.class).map(MULTIPLICATION);
        visit(UDivInstContext.class).map(DIVISION);
        visit(SDivInstContext.class).map(DIVISION);
        visit(FDivInstContext.class).map(DIVISION);
        visit(URemInstContext.class).map(REMAINDER);
        visit(SRemInstContext.class).map(REMAINDER);
        visit(FRemInstContext.class).map(REMAINDER);
        visit(ShlInstContext.class).map(SHIFT);
        visit(LShrInstContext.class).map(SHIFT);
        visit(AShrInstContext.class).map(SHIFT);
        visit(AndInstContext.class).map(AND);
        visit(OrInstContext.class).map(OR);
        visit(XorInstContext.class).map(XOR);
        visit(ExtractElementInstContext.class).map(EXTRACT_ELEMENT);
        visit(InsertElementInstContext.class).map(INSERT_ELEMENT);
        visit(ShuffleVectorInstContext.class).map(SHUFFLE_VECTOR);
        visit(ExtractValueInstContext.class).map(EXTRACT_VALUE);
        visit(InsertValueInstContext.class).map(INSERT_VALUE);
        visit(AllocaInstContext.class).map(ALLOCATION);
        visit(LoadInstContext.class).map(LOAD);
        visit(CmpXchgInstContext.class).map(COMPARE_EXCHANGE);
        visit(AtomicRMWInstContext.class).map(ATOMIC_READ_MODIFY_WRITE);
        visit(GetElementPtrInstContext.class).map(GET_ELEMENT_POINTER);
        visit(TruncInstContext.class).map(CONVERSION);
        visit(ZExtInstContext.class).map(CONVERSION);
        visit(SExtInstContext.class).map(CONVERSION);
        visit(FpTruncInstContext.class).map(CONVERSION);
        visit(FpExtInstContext.class).map(CONVERSION);
        visit(FpToUiInstContext.class).map(CONVERSION);
        visit(FpToSiInstContext.class).map(CONVERSION);
        visit(UiToFpInstContext.class).map(CONVERSION);
        visit(SiToFpInstContext.class).map(CONVERSION);
        visit(PtrToIntInstContext.class).map(CONVERSION);
        visit(IntToPtrInstContext.class).map(CONVERSION);
        visit(BitCastInstContext.class).map(BITCAST);
        visit(AddrSpaceCastInstContext.class).map(CONVERSION);
        visit(ICmpInstContext.class).map(COMPARISON);
        visit(FCmpInstContext.class).map(COMPARISON);
        visit(PhiInstContext.class).map(PHI);
        visit(SelectInstContext.class).map(SELECT);
        visit(CallInstContext.class).map(CALL);
        visit(VaargInstContext.class).map(VARIABLE_ARGUMENT);
        visit(LandingPadInstContext.class).map(LANDING_PAD);
        visit(CatchPadInstContext.class).map(CATCH_PAD);
        visit(CleanupPadInstContext.class).map(CLEAN_UP_PAD);
        visit(ClauseContext.class).map(CLAUSE);
        visit(AtomicOrderingContext.class).map(ATOMIC_ORDERING);
    }
}
